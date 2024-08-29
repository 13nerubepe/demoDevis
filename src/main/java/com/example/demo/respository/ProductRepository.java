package com.example.demo.respository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.UUID;

//@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByProductName(String productName);
}
