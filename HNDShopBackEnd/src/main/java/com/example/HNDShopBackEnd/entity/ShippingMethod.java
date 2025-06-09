package com.example.HNDShopBackEnd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "shipping_methods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShippingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String shippingMethodName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "shipping_fee", nullable = false)
    private BigDecimal shippingFee;

    @OneToMany(mappedBy = "shippingMethod")
    private List<Order> orders; // Đổi tên thành "orders" để tuân theo quy ước số nhiều

    // Getters, setters, constructors
}