package com.franchise.management.application.service;

import com.franchise.management.application.dto.FranchiseDTO;

import java.util.List;

public interface  FranchiseService {
    FranchiseDTO  createFranchise(FranchiseDTO franchise);
    List<FranchiseDTO > getAllFranchises();
    FranchiseDTO updateFranchiseName(Long franchiseId, String newName);
}
