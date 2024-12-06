package com.franchise.management.application.serviceImpl;

import com.franchise.management.application.dto.FranchiseDTO;
import com.franchise.management.application.mapper.FranchiseMapper;
import com.franchise.management.application.service.FranchiseService;
import com.franchise.management.domain.model.Franchise;
import com.franchise.management.domain.repository.FranchiseRepository;
import com.franchise.management.infraestructure.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final FranchiseMapper franchiseMapper;

    @Override
    public FranchiseDTO createFranchise(FranchiseDTO franchiseDTO) {
        Franchise franchise = franchiseMapper.toEntity(franchiseDTO);
        Franchise savedFranchise = franchiseRepository.save(franchise);
        return franchiseMapper.toDTO(savedFranchise);
    }

    @Override
    public List<FranchiseDTO> getAllFranchises() {
        return franchiseRepository.findAll().stream()
                .map(franchiseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FranchiseDTO updateFranchiseName(Long franchiseId, String newName) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new ResourceNotFoundException("Franchise not found", franchiseId));
        franchise.setNameFranchise(newName);
        Franchise updatedFranchise = franchiseRepository.save(franchise);
        return franchiseMapper.toDTO(updatedFranchise);
    }
}
