package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContaining(@RequestParam String nameProduct, Pageable pageable);
    Page<Product> findByCategoryId( Long categoryId, Pageable pageable);
    Page<Product> findByBrand(@RequestParam("brand") String brand, Pageable pageable);
}
