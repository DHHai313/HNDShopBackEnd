package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
