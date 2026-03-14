package com.sergiourbina.bomservice.domain.ports.out;

import com.sergiourbina.bomservice.domain.model.Product;

import java.util.Optional;

public interface  ProductRepositoryPort {
    Product save(Product product);

    Optional<Product> findById(Long id);
}
