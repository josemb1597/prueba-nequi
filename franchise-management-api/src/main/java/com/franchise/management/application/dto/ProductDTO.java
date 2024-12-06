package com.franchise.management.application.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String nameProduct;
    private int stock;
}
