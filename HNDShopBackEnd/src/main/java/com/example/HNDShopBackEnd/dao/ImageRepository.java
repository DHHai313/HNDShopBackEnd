package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
