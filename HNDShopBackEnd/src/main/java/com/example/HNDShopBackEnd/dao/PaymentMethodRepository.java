package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "payments-methods")
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
