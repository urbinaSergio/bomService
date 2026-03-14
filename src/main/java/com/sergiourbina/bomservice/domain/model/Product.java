package com.sergiourbina.bomservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String name;
    private List<Material> materials = new ArrayList<>();

    public void addMaterial(Material material) {
        this.materials.add(material);
    }
}
