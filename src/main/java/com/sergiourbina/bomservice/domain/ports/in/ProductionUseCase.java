package com.sergiourbina.bomservice.domain.ports.in;

import com.sergiourbina.bomservice.application.dto.ProductionResponse;

public interface ProductionUseCase {

    ProductionResponse calculateMaterials(Long productId, Integer quantity);
}
