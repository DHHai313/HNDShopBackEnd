package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.ElectronicComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "electronic-components")

public interface ElectronicComponentRepository extends JpaRepository<ElectronicComponent, Long> {
}
