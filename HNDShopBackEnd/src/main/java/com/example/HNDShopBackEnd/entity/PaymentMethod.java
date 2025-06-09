package com.example.HNDShopBackEnd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "payment_methods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentMethodId;

    @Column(nullable = false)
    private String paymentMethodName;

    private String description;

    @Column(name = "payment_fee", nullable = false)
    private BigDecimal paymentFee;

    @OneToMany(mappedBy = "paymentMethod")
    private List<Order> order;

    // Getters, setters, constructors
}