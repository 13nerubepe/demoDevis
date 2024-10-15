package com.example.demo.controlleur;

import com.example.demo.entity.Client;
import com.example.demo.entity.DTO.DevisCreateDto;
import com.example.demo.entity.DTO.DevisPaginationDto;
import com.example.demo.entity.Devis;
import com.example.demo.entity.Product;
import com.example.demo.sevice.definir.ClientService;
import com.example.demo.sevice.definir.DevisService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/devis")
@RestController
@AllArgsConstructor
public class DevisControlleur {

    private final DevisService devisService;

//    @GetMapping("/listeDevis")
//    public ResponseEntity<Page<Devis>> getListeDevis(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "4") int size){
//        Page<Devis> devis = devisService.getDevis(page, size);
//        return ResponseEntity.ok(devis);
//    }

    @GetMapping("/pagination")
    public ResponseEntity<DevisPaginationDto> getDevisPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        DevisPaginationDto result = devisService.getDevis(page, size);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteDevis")
    public void deleteDevis(Devis devisId){}

    @PostMapping("/createDevis")
    public ResponseEntity createDevis(@RequestBody DevisCreateDto devis){
        Devis devis1 = devisService.createDevis(devis);
        Map<String, String> response = new HashMap<>();
        response.put("data", "devis creé");
        return ResponseEntity.ok(response);
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
