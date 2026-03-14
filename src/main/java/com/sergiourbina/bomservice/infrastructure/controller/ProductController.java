package com.sergiourbina.bomservice.infrastructure.controller;

import com.sergiourbina.bomservice.domain.model.Material;
import com.sergiourbina.bomservice.domain.model.Product;
import com.sergiourbina.bomservice.domain.ports.out.ProductRepositoryPort;
import com.sergiourbina.bomservice.infrastructure.controller.dto.CreateProductRequest;
import com.sergiourbina.bomservice.infrastructure.controller.dto.MaterialRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepositoryPort productRepository;

    public ProductController(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 1. Crear producto
     */
    @PostMapping
    public Product createProduct(@RequestBody CreateProductRequest request) {

        Product product = new Product();
        product.setName(request.getName());

        return productRepository.save(product);
    }

    /**
     * 2. Agregar materiales al producto (BOM)
     */
    @PostMapping("/{productId}/materials")
    public Product addMaterial(
            @PathVariable Long productId,
            @RequestBody MaterialRequest request) {

        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        Product product = optionalProduct.get();

        Material material = new Material(
                request.getMaterial(),
                request.getQuantity()
        );



        // Validar si el material ya existe
        boolean exists = product.getMaterials()
                .stream()
                .anyMatch(m -> m.getMaterial().equals(request.getMaterial()));

        if (!exists) {
            product.addMaterial(material);
        }

        return productRepository.save(product);
    }
}
