package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.ShippingMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingMethodRepository extends JpaRepository<ShippingMethod, Long> {
}
