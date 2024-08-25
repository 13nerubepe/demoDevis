package com.example.demo.init;

import com.example.demo.entity.Product;
import com.example.demo.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {
//    private final ProductRepository productRepository;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Product p1 = Product.builder()
//                .image("productX.jpg")
//                .productName("Product A")
////                .devis(new ArrayList<>())
//                .qteenstock(100L)
//                .unite("LITRE,...")
//                .prixUnitaire(50L)
//                .tva(20L)
//                .totalTva(10L)
//                .totalHT(500L)
//                .categories("Category 1")
//                .description("Description for Product X")
//                .build();
//        Product p2 = Product.builder()
//                .image("productX.jpg")
//                .productName("Product A")
////                .devis(new ArrayList<>())
//                .qteenstock(100L)
//                .unite("LITRE,...")
//                .prixUnitaire(50L)
//                .tva(20L)
//                .totalTva(10L)
//                .totalHT(500L)
//                .categories("Category 1")
//                .description("Description for Product X")
//                .build();
//        Product p3 = Product.builder()
//                .image("productX.jpg")
//                .productName("Product A")
//                .devis(new ArrayList<>())
//                .qteenstock(100L)
//                .unite("LITRE,...")
//                .prixUnitaire(50L)
//                .tva(20L)
//                .totalTva(10L)
////                .totalHT(500L)
//                .categories("Category 1")
//                .description("Description for Product X")
//                .build();
//        Product p4 = Product.builder()
//                .image("productX.jpg")
//                .productName("Product A")
//                .devis(new ArrayList<>())
//                .qteenstock(100L)
//                .unite("LITRE,...")
//                .prixUnitaire(50L)
//                .tva(20L)
//                .totalTva(10L)
//                .totalHT(500L)
//                .categories("Category 1")
//                .description("Description for Product X")
//                .build();
//        Product p5 = Product.builder()
//                .image("productX.jpg")
//                .productName("Product A")
//                .devis(new ArrayList<>())
//                .qteenstock(100L)
//                .unite("LITRE,...")
//                .prixUnitaire(50L)
//                .tva(20L)
//                .totalTva(10L)
//                .totalHT(500L)
//                .categories("Category 1")
//                .description("Description for Product X")
//                .build();
//        Product p6 = Product.builder()
//                .image("productX.jpg")
//                .productName("Product A")
//                .devis(new ArrayList<>())
//                .qteenstock(100L)
//                .unite("LITRE,...")
//                .prixUnitaire(50L)
//                .tva(20L)
//                .totalTva(10L)
//                .totalHT(500L)
//                .categories("Category 1")
//                .description("Description for Product X")
//                .build();
//
//        productRepository.saveAll(List.of(p1,p2,p3,p4,p5,p6));
//    }
//}
