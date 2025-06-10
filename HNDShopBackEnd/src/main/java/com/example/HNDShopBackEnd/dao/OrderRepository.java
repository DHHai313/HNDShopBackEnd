package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
