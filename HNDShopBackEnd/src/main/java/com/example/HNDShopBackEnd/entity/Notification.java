package com.example.HNDShopBackEnd.entity;

import lombok.Data;


public class Notification {
    private String content;

    public Notification() {
    }

    public Notification(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
