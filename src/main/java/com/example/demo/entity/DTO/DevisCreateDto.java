package com.example.demo.entity.DTO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record DevisCreateDto(
                            UUID devisId,
                             int totalTHt,
                             boolean reduction,
                             int totalTva,
                             LocalDateTime date,
                             String cassier,
                             String clientId,
                             List<String> productIds) {
}
