package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "order-details")
public interface OderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
