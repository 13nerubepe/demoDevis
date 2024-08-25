package com.example.demo.respository;

import com.example.demo.entity.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepository  extends JpaRepository<Devis, Long> {
}
