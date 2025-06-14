package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cart-details")
public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
}
