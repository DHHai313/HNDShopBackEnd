package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer,Long> {
}
