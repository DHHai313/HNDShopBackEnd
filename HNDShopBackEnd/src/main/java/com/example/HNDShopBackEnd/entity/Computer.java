package com.example.HNDShopBackEnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Computer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Computer extends Product {

    @Column(name = "cpu", nullable = false)
    private String cpu;

    @Column(name = "ram", nullable = false)
    private String ram;

    @Column(name = "storage", nullable = false)
    private String storage;
}
