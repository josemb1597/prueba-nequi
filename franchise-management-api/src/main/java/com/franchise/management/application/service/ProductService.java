package com.franchise.management.application.service;


import com.franchise.management.application.dto.ProductDTO;
import com.franchise.management.application.dto.ProductNameDTO;
import com.franchise.management.application.dto.TopProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO addProductToBranch(Long branchId, ProductDTO product);
    void deleteProduct(Long productId);
    ProductDTO  updateStock(Long productId, int stock);
    ProductDTO updateProductName(Long productId, ProductNameDTO productNameDTO);
    List<TopProductDTO> findTopProductsByBranchForFranchise(Long franchiseId);
}
