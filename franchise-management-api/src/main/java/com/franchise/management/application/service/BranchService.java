package com.franchise.management.application.service;

import com.franchise.management.application.dto.BranchDTO;
import com.franchise.management.application.dto.BranchNameDTO;

public interface  BranchService {
    BranchDTO addBranchToFranchise(Long franchiseId, BranchDTO  branch);
    BranchDTO updateNameBranch(Long branchId, BranchNameDTO branchNameDTO);
}
