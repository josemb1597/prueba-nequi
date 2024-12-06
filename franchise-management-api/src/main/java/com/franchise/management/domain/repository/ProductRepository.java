package com.franchise.management.domain.repository;

import com.franchise.management.application.dto.TopProductDTO;
import com.franchise.management.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.* " +
            "FROM products p " +
            "INNER JOIN branches b ON p.branch_id = b.id " +
            "WHERE b.franchise_id = :franchiseId " +
            "AND p.stock = (" +
            "    SELECT MAX(p2.stock) " +
            "    FROM products p2 " +
            "    WHERE p2.branch_id = p.branch_id" +
            ")",
            nativeQuery = true)
    List<Product> findTopProductsByBranchForFranchise(@Param("franchiseId") Long franchiseId);
}
