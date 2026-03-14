package com.sergiourbina.bomservice.infrastructure.persistence.adapter;

import com.sergiourbina.bomservice.domain.model.Material;
import com.sergiourbina.bomservice.domain.model.Product;
import com.sergiourbina.bomservice.domain.ports.out.ProductRepositoryPort;
import com.sergiourbina.bomservice.infrastructure.persistence.entity.MaterialEntity;
import com.sergiourbina.bomservice.infrastructure.persistence.entity.ProductEntity;
import com.sergiourbina.bomservice.infrastructure.persistence.repository.ProductJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductJpaRepository repository;

    public ProductRepositoryAdapter(ProductJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = toEntity(product);

        ProductEntity saved = repository.save(entity);

        return toDomain(saved);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id)
                .map(this::toDomain);
    }

    private ProductEntity toEntity(Product product) {

        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());

        if (product.getMaterials() != null) {

            List<MaterialEntity> materials = product.getMaterials()
                    .stream()
                    .map(m -> {
                        MaterialEntity me = new MaterialEntity();
                        me.setMaterial(m.getMaterial());
                        me.setQuantity(m.getQuantity());
                        me.setProduct(entity);
                        return me;
                    })
                    .collect(Collectors.toList());

            entity.setMaterials(materials);
        }

        return entity;
    }

    private Product toDomain(ProductEntity entity) {

        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());

        if (entity.getMaterials() != null) {

            List<Material> materials = entity.getMaterials()
                    .stream()
                    .map(m -> {
                        Material material = new Material();
                        material.setMaterial(m.getMaterial());
                        material.setQuantity(m.getQuantity());
                        return material;
                    })
                    .collect(Collectors.toList());

            product.setMaterials(materials);
        }

        return product;
    }



}
