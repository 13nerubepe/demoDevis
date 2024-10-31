package com.example.demo.respository;

import com.example.demo.entity.ProduitDevis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProduitDevisRepository extends JpaRepository<ProduitDevis, UUID> {
}
