package com.franchise.management.application.controller;

import com.franchise.management.application.dto.FranchiseDTO;
import com.franchise.management.application.dto.FranchiseNameDTO;
import com.franchise.management.application.service.FranchiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franchises")
@RequiredArgsConstructor
public class FranchiseController {

    private final FranchiseService franchiseService;

    @PostMapping
    public ResponseEntity<FranchiseDTO> createFranchise(@RequestBody FranchiseDTO franchiseDTO) {
        FranchiseDTO createdFranchise = franchiseService.createFranchise(franchiseDTO);
        return new ResponseEntity<>(createdFranchise, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FranchiseDTO>> getAllFranchises() {
        List<FranchiseDTO> franchises = franchiseService.getAllFranchises();
        return new ResponseEntity<>(franchises, HttpStatus.OK);
    }

    @PutMapping("/{franchiseId}/name")
    public ResponseEntity<FranchiseDTO> updateFranchiseName(
            @PathVariable Long franchiseId,
            @RequestBody FranchiseNameDTO franchiseNameDTO) {
        FranchiseDTO updatedFranchise = franchiseService.updateFranchiseName(franchiseId, franchiseNameDTO.getNameFranchise());
        return ResponseEntity.ok(updatedFranchise);
    }
}
