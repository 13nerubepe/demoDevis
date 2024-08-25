package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "client",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phone"),
        @UniqueConstraint(columnNames = "nom")
})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long clientId;
    private String image;
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    private String email;
    @NotBlank(message = "Le numero de telephone est obligatoire")
    private String phone ;
    private String address;
    private String ville;
    private String grade;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Devis> devis;

//
//    // Relation OneToMany avec Devis
//    @OneToMany(mappedBy = "client")
//    private List<Devis> devis;
//
//    public static Object builder() {
//        return null;
//    }
}
