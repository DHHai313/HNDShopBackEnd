package com.example.HNDShopBackEnd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Camera")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Camera extends Product {
    @Column(name = "resolution", nullable = false)
    private String resolution;

    @Column(name = "lens_type", nullable = false)
    private String lensType;
}