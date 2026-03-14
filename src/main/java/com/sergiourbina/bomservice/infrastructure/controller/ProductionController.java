package com.sergiourbina.bomservice.infrastructure.controller;

import com.sergiourbina.bomservice.application.dto.ProductionResponse;
import com.sergiourbina.bomservice.domain.ports.in.ProductionUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/production")
public class ProductionController {

    private final ProductionUseCase productionUseCase;

    public ProductionController(ProductionUseCase productionUseCase) {
        this.productionUseCase = productionUseCase;
    }

    /**
     * 3. Calcular materiales necesarios para producción
     */
    @GetMapping("/calculate")
    public ProductionResponse calculateProduction(
            @RequestParam Long productId,
            @RequestParam Integer quantity) {

        return productionUseCase.calculateMaterials(productId, quantity);
    }
}
