package com.franchise.management.application.mapper;

import com.franchise.management.application.dto.BranchDTO;
import com.franchise.management.domain.model.Branch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = FranchiseMapper.class)
public interface  BranchMapper {
    BranchDTO toDTO(Branch branch);
    Branch toEntity(BranchDTO branchDTO);
}
