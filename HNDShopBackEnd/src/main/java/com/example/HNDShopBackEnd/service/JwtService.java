package com.example.HNDShopBackEnd.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {
    public static final String JWT_SECRET = "";

    //Tạo JWT trên username
//    public String generateToken(String username) {
//        Map<String, Object> claims = new HashMap<>();
//        return createToken(claims,username);
//    }
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", userDetails.getAuthorities().stream()
                .map(auth -> auth.getAuthority())
                .toList()); // hoặc Collectors.toList()
        return createToken(claims, userDetails.getUsername());
    }

    //Tao JWT voi claims
    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+30*60*1000))
                .signWith(SignatureAlgorithm.HS256,getSignKey())
                .compact();
    }
    //Lay serect key
    private Key getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(JWT_SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //Trich xuat thong tin
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getSignKey()).parseClaimsJws(token).getBody();
    }
    //Trich xuat thong tin cho 1 claim
    public <T> T extractClaims(String token, Function<Claims, T> claimsFunction) {
        final Claims claims = extractAllClaims(token);
        return claimsFunction.apply(claims);
    }
    //Kiem tra thoi gian het han
    public Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }
    //Kiem tra thoi gian het han
    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }
    //Kiem tra Jwt da het han
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    //Kiem tra tinh hop le
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = (String) extractClaims(token, Claims::getSubject);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


}
