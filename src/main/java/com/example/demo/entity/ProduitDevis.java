package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProduitDevis {
    @Id
    @GeneratedValue
    private UUID id;
    private int qte;
    @OneToOne
    private Product product;

    @ManyToOne
    private Devis devis;
}

