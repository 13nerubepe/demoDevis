package com.example.demo.entity.DTO;

import com.example.demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProduitDevisDto {
    private Product product;
    private int qte;
}
