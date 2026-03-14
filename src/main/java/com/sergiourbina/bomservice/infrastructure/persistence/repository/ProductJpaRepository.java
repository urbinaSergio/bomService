package com.sergiourbina.bomservice.infrastructure.persistence.repository;

import com.sergiourbina.bomservice.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
