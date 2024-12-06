package com.franchise.management.application.controller;

import com.franchise.management.application.dto.ProductDTO;
import com.franchise.management.application.dto.ProductNameDTO;
import com.franchise.management.application.dto.TopProductDTO;
import com.franchise.management.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/branch/{branchId}")
    public ResponseEntity<ProductDTO> addProductToBranch(@PathVariable Long branchId, @RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.addProductToBranch(branchId, productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateStock(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ProductDTO updatedProduct = productService.updateStock(id, productDTO.getStock());
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{productId}/name")
    public ResponseEntity<ProductDTO> updateProductName(
            @PathVariable Long productId,
            @RequestBody ProductNameDTO productNameDTO) {
        ProductDTO updatedProduct = productService.updateProductName(productId, productNameDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/top-products/{franchiseId}")
    public ResponseEntity<List<TopProductDTO>> getTopProductsByBranchForFranchise(
            @PathVariable Long franchiseId) {
        List<TopProductDTO> topProducts = productService.findTopProductsByBranchForFranchise(franchiseId);
        return ResponseEntity.ok(topProducts);
    }
}
