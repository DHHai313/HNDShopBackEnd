package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
