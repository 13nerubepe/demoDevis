package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
import java.util.UUID;

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
    @GeneratedValue(strategy = GenerationType.UUID)

    private String clientId;
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

}
