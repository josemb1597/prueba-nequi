package com.franchise.management.application.serviceImpl;

import com.franchise.management.application.dto.BranchDTO;
import com.franchise.management.application.dto.BranchNameDTO;
import com.franchise.management.application.mapper.BranchMapper;
import com.franchise.management.application.service.BranchService;
import com.franchise.management.domain.model.Branch;
import com.franchise.management.domain.model.Franchise;
import com.franchise.management.domain.repository.BranchRepository;
import com.franchise.management.domain.repository.FranchiseRepository;
import com.franchise.management.infraestructure.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final FranchiseRepository franchiseRepository;
    private final BranchMapper branchMapper;

    @Override
    public BranchDTO addBranchToFranchise(Long franchiseId, BranchDTO branchDTO) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new ResourceNotFoundException("Franchise not found", franchiseId));
        Branch branch = branchMapper.toEntity(branchDTO);
        branch.setFranchise(franchise);
        Branch savedBranch = branchRepository.save(branch);
        return branchMapper.toDTO(savedBranch);
    }

    @Override
    public BranchDTO updateNameBranch(Long branchId, BranchNameDTO branchUpdateDTO) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found", branchId));
        branch.setNameBranch(branchUpdateDTO.getNameBranch());
        Branch updatedBranch = branchRepository.save(branch);
        return branchMapper.toDTO(updatedBranch);
    }
}
