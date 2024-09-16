package com.example.demo.sevice.implementation;

import com.example.demo.entity.Client;
import com.example.demo.entity.DTO.DevisCreateDto;
import com.example.demo.entity.Devis;
import com.example.demo.entity.Product;
import com.example.demo.respository.ClientRepository;
import com.example.demo.respository.DevisRepository;
import com.example.demo.respository.ProductRepository;
import com.example.demo.sevice.definir.DevisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DevisServiceI implements DevisService {

    private final DevisRepository devisRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    @Override
    public List<Devis> getDevis() {
        return this.devisRepository.findAll();
    }

//    @Override
//    public Devis createDevis(Devis devis) {
//        return this.devisRepository.save(devis);
//    }
    @Override
public Devis createDevis(DevisCreateDto devisCreateDto) {

        // Vérification de la nullité de "cassier"
        if (devisCreateDto.cassier() == null || devisCreateDto.cassier().isEmpty()) {
            throw new RuntimeException("Cassier cannot be null or empty");
        }


    // Récupérer les entités client et produits par leurs ID
//        UUID clientId = UUID.fromString(devisCreateDto.clientId());
//    Client client = clientRepository.findById(clientId)
//            .orElseThrow(() -> new RuntimeException("Client not found"));

        Client client = clientRepository.findById(devisCreateDto.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

    List<Product> products = productRepository.findAllById(devisCreateDto.productIds());

    // Créer un nouvel objet Devis
    Devis devis = new Devis();
//    convertir le string en UUID
//    devis.setDevisId(UUID.fromString(devisCreateDto.devisId()));
        devis.setDevisId(devisCreateDto.devisId());

    devis.setTotalTHt(devisCreateDto.totalTHt());
    devis.setReduction(devisCreateDto.reduction());
    devis.setTotalTva(devisCreateDto.totalTva());
    devis.setDate(devisCreateDto.date());
    devis.setCassier(devisCreateDto.cassier());  // Assurez-vous que ce champ est non nul
    devis.setClient(client);
    devis.setProducts(products);

        return devisRepository.save(devis);
}
}
