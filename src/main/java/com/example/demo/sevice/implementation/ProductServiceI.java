package com.example.demo.sevice.implementation;

import com.example.demo.entity.Product;
import com.example.demo.respository.ProductRepository;
import com.example.demo.sevice.definir.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceI implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceI(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(Product product) {
        //verify si le product existe deja
        if(productRepository.findByProductName(product.getProductName()).isPresent()){
//        throw new IllegalArgumentException("Product with name " + productName + " already exists.");
        }
        this.productRepository.save(product);
    }

    @Override
    public List<Product> getListProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public void deleteProduct(UUID productId) {
        this.productRepository.deleteById(productId);

    }
    //nest pas encore verify
    @Override
    public Product getProduct(UUID productId) {
//        Optional<Product> product = this.productRepository.findById(productId);
//        return product.orElseThrow(() -> new RuntimeException("Produit non trouvé pour l'ID : " + productId));
//
        return null;
    }
}
