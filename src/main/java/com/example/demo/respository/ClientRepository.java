package com.example.demo.respository;

import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByNom(String nom);

//    @Override
//    Optional<Client> findById(Long aLong);
//    Optional<Client> findByEmail(String email);
//
//    Optional<Client> findByPhone(String phone);
//
//    Optional<Client> findByNom(String nom);
}
