package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cameras")
public interface CameraRepository extends JpaRepository<Camera, Integer> {
}
