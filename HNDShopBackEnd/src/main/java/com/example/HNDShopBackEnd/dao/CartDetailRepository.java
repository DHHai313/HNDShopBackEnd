package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
}
