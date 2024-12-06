package com.franchise.management.application.dto;

import lombok.Data;

@Data
public class TopProductDTO {
    private Long id;
    private String nameProduct;
    private int stock;
    private String branchName;
}
