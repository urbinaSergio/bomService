package com.sergiourbina.bomservice.infrastructure.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MaterialRequest {
    private String material;
    private Integer quantity;
}
