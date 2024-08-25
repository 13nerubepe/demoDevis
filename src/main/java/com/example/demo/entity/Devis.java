package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long devisId;
    private Long totalTHt;
    private String reduction;
    private Long totalTva;
    private String date;
    private String cassier;
//lie a un seul client
    @ManyToOne
    @JoinColumn(name = "clientId", insertable = false, updatable = false, nullable = false)
    private Client client;

//    lie a plusieurs clients
//@ManyToMany
//@JoinTable(
//        name = "devis_client",
//        joinColumns = @JoinColumn(name = "devisId"),
//        inverseJoinColumns = @JoinColumn(name = "clientId")
//)
//private List<Client> clients;

    @ManyToMany
    @JoinColumn(name = "productId", insertable = false, updatable = false, nullable = false)
    private List<Product> product;

}

