package com.example.HNDShopBackEnd.service;

import org.springframework.stereotype.Service;


public interface EmailService {

    public void sendMessage(String from, String to, String subject, String text);
}
