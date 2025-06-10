package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
