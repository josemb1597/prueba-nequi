package com.franchise.management.application.serviceImpl;

import com.franchise.management.application.dto.ProductDTO;
import com.franchise.management.application.dto.ProductNameDTO;
import com.franchise.management.application.dto.TopProductDTO;
import com.franchise.management.application.mapper.ProductMapper;
import com.franchise.management.application.service.ProductService;
import com.franchise.management.domain.model.Branch;
import com.franchise.management.domain.model.Product;
import com.franchise.management.domain.repository.BranchRepository;
import com.franchise.management.domain.repository.ProductRepository;
import com.franchise.management.infraestructure.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO addProductToBranch(Long branchId, ProductDTO productDTO) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found", branchId));
        Product product = productMapper.toEntity(productDTO);
        product.setBranch(branch);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductDTO updateStock(Long productId, int stock) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found", productId));
        product.setStock(stock);
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDTO(updatedProduct);
    }

    @Override
    public ProductDTO updateProductName(Long productId, ProductNameDTO productNameDTO) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found", productId));
        product.setNameProduct(productNameDTO.getNameProduct());
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDTO(updatedProduct);
    }

    public List<TopProductDTO> findTopProductsByBranchForFranchise(Long franchiseId) {
        List<Product> topProducts = productRepository.findTopProductsByBranchForFranchise(franchiseId);
        return topProducts.stream()
                .map(productMapper::toTopProductDTO) // Convirtiendo cada Product a TopProductDTO
                .collect(Collectors.toList());
    }
}
