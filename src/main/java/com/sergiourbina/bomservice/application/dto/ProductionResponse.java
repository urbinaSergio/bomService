package com.sergiourbina.bomservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductionResponse {
    private String product;
    private Integer quantity;
    private List<MaterialRequired> materials;
}
