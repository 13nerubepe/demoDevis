package com.example.demo.controlleur;

import com.example.demo.entity.Client;
import com.example.demo.entity.DTO.DevisCreateDto;
import com.example.demo.entity.Devis;
import com.example.demo.entity.Product;
import com.example.demo.sevice.definir.ClientService;
import com.example.demo.sevice.definir.DevisService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/devis")
@RestController
@AllArgsConstructor
public class DevisControlleur {

    private final DevisService devisService;

    @GetMapping("/listeDevis")
    public ResponseEntity<List<Devis>> getListeDevis(){
        List<Devis> devisList = devisService.getDevis();
        return ResponseEntity.ok(devisList);
    }

    @DeleteMapping("/deleteDevis")
    public void deleteDevis(Devis devisId){}

    @PostMapping("/reateDevis")
    public ResponseEntity createDevis(@RequestBody DevisCreateDto devis){
        devisService.createDevis(devis);
        return ResponseEntity.ok("devis creé");
    }
//@PostMapping
//public ResponseEntity<Devis> createDevis(@RequestBody DevisRequest devisRequest) {
//    Client client = clientService.getClientById(devisRequest.getClientId());
//    List<Product> products = devisRequest.getProductIds().stream()
//            .map(productId -> productService.getProductById(productId))
//            .collect(Collectors.toList());
//
//    // Créer et sauvegarder le devis ici
//    Devis devis = new Devis();
//    devis.setClient(client);
//    devis.setProducts(products);
//    // autres champs
//    // devisRepository.save(devis);
//
//    return ResponseEntity.ok(devis);
//}
}
