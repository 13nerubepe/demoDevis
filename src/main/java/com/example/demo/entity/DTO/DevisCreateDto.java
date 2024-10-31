package com.example.demo.entity.DTO;

import com.example.demo.entity.ProduitDevis;

import java.time.LocalDateTime;

import java.util.List;
import java.util.UUID;

public record DevisCreateDto(
                            UUID devisId,
                             int totalTHt,
                             boolean reduction,
                             int totalTva,
                             LocalDateTime date,
                             String cassier,
                            String productName,
                            int tva,

                            UUID clientId,
//                             List<UUID> clientId,
                             List<ProduitDevisDto> productDevis




) {
}
