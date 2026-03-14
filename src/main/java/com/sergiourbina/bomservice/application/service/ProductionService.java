package com.sergiourbina.bomservice.application.service;

import com.sergiourbina.bomservice.application.dto.MaterialRequired;
import com.sergiourbina.bomservice.application.dto.ProductionResponse;
import com.sergiourbina.bomservice.domain.model.Material;
import com.sergiourbina.bomservice.domain.model.Product;
import com.sergiourbina.bomservice.domain.ports.in.ProductionUseCase;
import com.sergiourbina.bomservice.domain.ports.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionService implements ProductionUseCase {

    private final ProductRepositoryPort repository;

    public ProductionService(ProductRepositoryPort repository) {
        this.repository = repository;
    }


    @Override
    public ProductionResponse calculateMaterials(Long productId, Integer quantity) {
        Product product = repository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        List<MaterialRequired> materials = product.getMaterials()
                .stream()
                .map(material -> calculateRequiredMaterial(material, quantity))
                .toList();

        return new ProductionResponse(
                product.getName(),
                quantity,
                materials
        );
    }

    private MaterialRequired calculateRequiredMaterial(Material material, Integer quantity) {

        Integer required = material.getQuantity() * quantity;

        return new MaterialRequired(
                material.getMaterial(),
                required
        );
    }
}
