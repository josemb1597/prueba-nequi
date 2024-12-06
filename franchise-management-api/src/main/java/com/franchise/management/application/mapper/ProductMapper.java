package com.franchise.management.application.mapper;

import com.franchise.management.application.dto.ProductDTO;
import com.franchise.management.application.dto.TopProductDTO;
import com.franchise.management.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = BranchMapper.class)
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);

    @Mapping(source = "branch.nameBranch", target = "branchName")
    TopProductDTO toTopProductDTO(Product product);
}
