package com.example.HNDShopBackEnd.service;

import com.example.HNDShopBackEnd.dao.UserRepository;
import com.example.HNDShopBackEnd.entity.Notification;
import com.example.HNDShopBackEnd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserAccountService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private EmailService emailService;

     public ResponseEntity<?> UserRegister(User user){
         // Kiểm tra tên đăng nhập đã tồn tại chưa
         if (userRepository.existsByUsername(user.getUsername())) {
             return ResponseEntity.badRequest().body(new Notification("Tên đăng nhập đã tồn tại."));
         }
         //kiem tra ten dang nhap da ton tai chua
         if (userRepository.existsByEmail(user.getEmail())) {
             return ResponseEntity.badRequest().body(new Notification("Email đã tồn tại."));
         }
         //Mã hóa trước khi lưu
         String encryptedPassword = encoder.encode(user.getPassword());
         user.setPassword(encryptedPassword);

         //Gắn và gửi thông tin kích hoạt
         user.setEnabledCode(createUUID());
         user.setEnabled(false);
         //Lưu vào csdl
         User savedUser = userRepository.save(user);
         //Gui email de kich hoat
         sendEmailEnable(user.getEmail(),user.getEnabledCode());
         return ResponseEntity.ok(savedUser);
     }
     //tao ma kich hoat
    private String createUUID(){
         return UUID.randomUUID().toString();
    }
    private void sendEmailEnable(String email, String enableCode) {
        String subject = "Kích hoạt tài khoản tại HNDShop";
        String url = "http://localhost:3000/enable/"+email+"/"+enableCode;
        String html = "<h2>Chào mừng bạn đến với HNDShop!</h2>"
                + "<p>Vui lòng sử dụng mã sau để kích hoạt tài khoản <strong>" + email + "</strong> của bạn:</p>"
                + "<div style='font-size:18px; font-weight:bold; color:blue;'>" + enableCode + "</div>"
                +"<br>Hoặc click vào đường link bên dưới: <br>" +" <a href="+url+">Kích hoạt<a/> <br>"
                + "<p>Nếu bạn không yêu cầu đăng ký, hãy bỏ qua email này.</p>";

        emailService.sendMessage("hoangtu312004@gmail.com", email, subject, html);
    }
    public ResponseEntity<?> enableAccount(String email, String enableCode) {
         User user = userRepository.findByEmail(email);
         if (user == null) {
             return ResponseEntity.badRequest().body(new Notification("User doesn't exist!"));
         }
         if (user.isEnabled()) {
             return ResponseEntity.badRequest().body(new Notification("User already enabled!"));
         }

         if (enableCode.equals(user.getEnabledCode())){
             user.setEnabled(true);
             userRepository.save(user);
             return ResponseEntity.ok().body(new Notification("User enabled!"));
         }else {
             return ResponseEntity.badRequest().body(new Notification("Enable code is incorrect!"));
         }

    }
}




