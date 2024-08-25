package com.example.demo.sevice.definir;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);
    List<Product> getListProduct();
    void deleteProduct(Long productId);
    Product getProduct(Long productId);
}
