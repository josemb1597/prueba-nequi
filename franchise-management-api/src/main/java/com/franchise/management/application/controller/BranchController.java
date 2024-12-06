package com.franchise.management.application.controller;

import com.franchise.management.application.dto.BranchDTO;
import com.franchise.management.application.dto.BranchNameDTO;
import com.franchise.management.application.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping("/franchise/{franchiseId}")
    public ResponseEntity<BranchDTO> addBranchToFranchise(@PathVariable Long franchiseId, @RequestBody BranchDTO branchDTO) {
        BranchDTO createdBranch = branchService.addBranchToFranchise(franchiseId, branchDTO);
        return new ResponseEntity<>(createdBranch, HttpStatus.CREATED);
    }

    @PutMapping("/{branchId}/name")
    public ResponseEntity<BranchDTO> updateNameBranch(
            @PathVariable Long branchId,
            @RequestBody BranchNameDTO branchNameDTO) {
        BranchDTO updatedBranch = branchService.updateNameBranch(branchId, branchNameDTO);
        return ResponseEntity.ok(updatedBranch);
    }
}
