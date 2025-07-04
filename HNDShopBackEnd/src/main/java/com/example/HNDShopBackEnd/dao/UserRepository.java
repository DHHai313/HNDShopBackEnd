package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
    public boolean existsByUsername(String username);
    public boolean existsByEmail(String email);
    public User findByUsername(String username);
    public User findByEmail(String email);
}
