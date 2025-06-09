package com.example.HNDShopBackEnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("ElectronicComponent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElectronicComponent extends Product {

    @Column(name = "component_type", nullable = false)
    private String componentType;
}
