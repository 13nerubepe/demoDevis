package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID productId;
    private String productName;
    private String image;
    private String libele;
    private String unite;
    private String description;
    private String categories;
    private Long prixUnitaire;
    private Long qteenstock;
    private Long qte;
    private Long tva;
    private Long totalTva;
    private Long totalHT;

}
