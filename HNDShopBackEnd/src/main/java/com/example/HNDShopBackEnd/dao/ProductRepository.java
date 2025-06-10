package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
