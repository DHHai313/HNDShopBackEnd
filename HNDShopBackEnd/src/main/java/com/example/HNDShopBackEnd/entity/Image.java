package com.example.HNDShopBackEnd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "icon_url", nullable = false)
    private String icon; // URL của ảnh chính hiển thị trên trang chủ

    @ElementCollection
    @Column(name = "url")
    private List<String> url; // Danh sách URL của các ảnh phụ cho slide

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; // Liên kết với thực thể Product

    // Getters, setters, constructors
}