package com.franchise.management.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nameBranch;

    @ManyToOne
    @JoinColumn(name = "franchise_id", nullable = false, foreignKey = @ForeignKey(name = "fk_branches_franchises"))
    private Franchise franchise;
}
