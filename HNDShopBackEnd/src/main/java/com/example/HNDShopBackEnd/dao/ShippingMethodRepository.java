package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.ShippingMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "shipping-methods")
public interface ShippingMethodRepository extends JpaRepository<ShippingMethod, Long> {
}
