package com.example.HNDShopBackEnd.controller;

import com.example.HNDShopBackEnd.entity.User;
import com.example.HNDShopBackEnd.security.JwtResponse;
import com.example.HNDShopBackEnd.security.LoginRequest;
import com.example.HNDShopBackEnd.service.JwtService;
import com.example.HNDShopBackEnd.service.UserAccountService;
import com.example.HNDShopBackEnd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;
    @PostMapping("/register")
    public ResponseEntity<?> UserRegister(@Validated @RequestBody User user) {
        ResponseEntity<?> response = userAccountService.UserRegister(user);
        return response;
    }
    @GetMapping("/enable")
    public ResponseEntity<?> enableUser(@RequestParam String email, @RequestParam String enableCode) {
        ResponseEntity<?> response = userAccountService.enableAccount(email, enableCode);
        return response;
    }
    @PostMapping("/login")
    public ResponseEntity<?> UserLogin(@RequestBody LoginRequest loginRequest) {
        try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword())
                );
                if (authentication.isAuthenticated()) {
                    var userDetails = userService.loadUserByUsername(loginRequest.getUsername());
                    final String jwt = jwtService.generateToken(userDetails);
                    return ResponseEntity.ok(new JwtResponse(jwt));
                }
        }catch (AuthenticationException exception){
                //Xac thuc khong thanh cong
            return ResponseEntity.badRequest().body("Tên đăng nhập hoặc mật khẩu không chính xác");
        }
        return ResponseEntity.badRequest().body("Xác thực không thành công");

    }
}
