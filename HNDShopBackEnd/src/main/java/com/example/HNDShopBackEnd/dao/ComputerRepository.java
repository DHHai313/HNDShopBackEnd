package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "computers")

public interface ComputerRepository extends JpaRepository<Computer,Long> {
}
