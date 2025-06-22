package com.example.HNDShopBackEnd.service;

import com.example.HNDShopBackEnd.dao.UserRepository;
import com.example.HNDShopBackEnd.entity.Notification;
import com.example.HNDShopBackEnd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
     public ResponseEntity<?> UserRegister(User user){
         //kiem tra ten dang nhap da ton tai chua
         if (userRepository.existsByUsername(user.getUsername())) {
             return ResponseEntity.badRequest().body(new Notification("Tên đăng nhập đã tồn tại."));
         }
         //kiem tra ten dang nhap da ton tai chua
         if (userRepository.existsByEmail(user.getEmail())) {
             return ResponseEntity.badRequest().body(new Notification("Email đã tồn tại."));
         }
         //Lưu vào csdl
         User savedUser = userRepository.save(user);
         return ResponseEntity.ok(savedUser);
     }
}
