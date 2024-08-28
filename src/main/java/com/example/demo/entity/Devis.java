package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID devisId;
    private int totalTHt;
    private boolean reduction;
    private int totalTva;
    private Date date;
    private String cassier;


//    @Column(name = "clientId", nullable = false)
//    private UUID clientId;
//
//    @ElementCollection
//    @CollectionTable(name = "devis_product", joinColumns = @JoinColumn(name = "devisId"))
//    @Column(name = "productId")
//    private List<UUID> productIds = new ArrayList<>();
@ManyToOne
@JoinColumn(name = "clientId", nullable = false)
private Client client;

    @ManyToMany
    @JoinTable(
            name = "devis_product",
            joinColumns = @JoinColumn(name = "devisId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> products = new ArrayList<>();

}

