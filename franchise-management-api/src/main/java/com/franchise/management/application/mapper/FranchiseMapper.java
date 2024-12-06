package com.franchise.management.application.mapper;

import com.franchise.management.application.dto.FranchiseDTO;
import com.franchise.management.domain.model.Franchise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface  FranchiseMapper {
    FranchiseDTO toDTO(Franchise franchise);
    Franchise toEntity(FranchiseDTO franchiseDTO);
}
