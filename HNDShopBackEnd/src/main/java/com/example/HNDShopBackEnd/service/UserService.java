package com.example.HNDShopBackEnd.service;

import com.example.HNDShopBackEnd.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUsername(String username);
}
