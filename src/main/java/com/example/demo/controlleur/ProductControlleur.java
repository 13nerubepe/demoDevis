package com.example.demo.controlleur;


import com.example.demo.entity.Product;
import com.example.demo.sevice.definir.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/product")
@RestController
@AllArgsConstructor
public class ProductControlleur {
    private final ProductService productService;


    @PostMapping("/createProduct")
    public ResponseEntity createProduct(Product product){
        this.productService.createProduct(product);
        return ResponseEntity.ok("Product created successfully");
    }
    @GetMapping("/listeProduct")
    public List<Product> listeProduct(){
        return  this.productService.getListProduct();
    }
    @DeleteMapping("/eleteProduct")
    public void deleteProduct(UUID productId){
        this.productService.deleteProduct(productId);
    }
    @GetMapping("/getProduct")
    public void getProduct(UUID productId){
        this.productService.getProduct(productId);
    }

//
//    @GetMapping("")
//    public List<Client> getlisteClient(){
//        return this.clientService.listeClient();
//    }
//
////    @GetMapping
////    public List<Client> getClientBy(String nom){
////        return this.clientService.getClientby(nom);
////    }
//
//    @PostMapping
//    public void createClient(Client client) {
//         this.clientService.createClient(client);
//    }
}
