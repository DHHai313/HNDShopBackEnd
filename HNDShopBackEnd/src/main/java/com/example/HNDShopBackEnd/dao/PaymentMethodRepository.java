package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
