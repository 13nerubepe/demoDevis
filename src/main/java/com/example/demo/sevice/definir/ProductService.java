package com.example.demo.sevice.definir;

import com.example.demo.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void createProduct(Product product);
    List<Product> getListProduct();
    void deleteProduct(UUID productId);
    Product getProduct(UUID productId);
}
