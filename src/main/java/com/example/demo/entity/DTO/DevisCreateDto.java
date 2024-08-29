package com.example.demo.entity.DTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record DevisCreateDto(String devisId,
                             int totalTHt,
                             boolean reduction,
                             int totalTva,
                             Date date,
                             String cassier,
                             String clientId,
                             List<String> productIds) {
}
