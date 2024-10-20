package com.example.demo.respository;

import com.example.demo.entity.Devis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DevisRepository  extends JpaRepository<Devis, UUID> {
//    Page<Devis> findAll(String cassier, Pageable pageable);
}
