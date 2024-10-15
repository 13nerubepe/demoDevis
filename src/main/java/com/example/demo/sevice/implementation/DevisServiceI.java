package com.example.demo.sevice.implementation;

import com.example.demo.entity.Client;
import com.example.demo.entity.DTO.DevisCreateDto;
import com.example.demo.entity.DTO.DevisPaginationDto;
import com.example.demo.entity.Devis;
import com.example.demo.entity.Product;
import com.example.demo.respository.ClientRepository;
import com.example.demo.respository.DevisRepository;
import com.example.demo.respository.ProductRepository;
import com.example.demo.sevice.definir.DevisService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DevisServiceI implements DevisService {

    private final DevisRepository devisRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
//    @Override
//    public Page<Devis> getDevis(int page, int size) {
//       return this.devisRepository.findAll(PageRequest.of(page, size));
//    }


    @Override
    public DevisPaginationDto getDevis(int page, int size) {
        Page<Devis> devisPage = this.devisRepository.findAll(PageRequest.of(page, size));

        return new DevisPaginationDto(
                devisPage.getContent(),
                devisPage.getTotalPages(),
                devisPage.getTotalElements(),
                devisPage.getNumber(),
                devisPage.isLast(),
                devisPage.isFirst()
        );

    }

//    @Override
//    public DevisPaginationDto getDevis(int page, int size) {
//        // Validation des paramètres
//        if (page < 0) {
//            throw new IllegalArgumentException("Le numéro de page ne peut pas être négatif.");
//        }
//        if (size <= 0) {
//            throw new IllegalArgumentException("La taille de la page doit être supérieure à zéro.");
//        }
//
//        // Création d'un objet Pageable pour la pagination
//        Pageable pageable = PageRequest.of(page, size);
//
//        // Récupération de la page de devis
//        Page<Devis> devisPage = devisRepository.findAll(pageable);
//
//        // Création du DTO de pagination
//        DevisPaginationDto dto = new DevisPaginationDto();
//        dto.setContent(devisPage.getContent());
//        dto.setTotalPages(devisPage.getTotalPages());
//        dto.setTotalElements(devisPage.getTotalElements());
//        dto.setPageNumber(devisPage.getNumber());
//        dto.setLast(devisPage.isLast());
//        dto.setFirst(devisPage.isFirst());  // Ajout d'informations sur la première page
//
//        return dto;
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

//    public List<DevisCreateDto> getAllDevisWithDetails() {
//        List<Devis> devisList = devisRepository.findAll();
//        List<DevisCreateDto> combinedDtos = new ArrayList<>();
//
//        for (Devis devis : devisList) {
//            DevisCreateDto dto = new DevisCreateDto();
//            dto.setDevisId(devisCreateDto.getdevisId());
//            dto.setTotalTHt(devis.getTotalTHt());
//            dto.setReduction(devis.isReduction());
//            dto.setTotalTva(devis.getTotalTva());
//            dto.setDate(devis.getDate());
//            dto.setCassier(devis.getCassier());
//
//            // Récupérer le nom du client
//            dto.setClientName(devis.getClient().getNom());
//
//            // Récupérer les noms des produits
//            List<String> productNames = devis.getProducts().stream()
//                    .map(Product::getProductName)
//                    .collect(Collectors.toList());
//            dto.setProductNames(productNames);
//
//            combinedDtos.add(dto);
//        }
//
//        return combinedDtos;
//    }
}
