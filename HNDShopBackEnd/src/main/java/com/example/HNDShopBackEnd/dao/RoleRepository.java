package com.example.HNDShopBackEnd.dao;

import com.example.HNDShopBackEnd.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "roles")
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByName(String name);
}
