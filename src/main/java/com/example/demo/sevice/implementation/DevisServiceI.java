package com.example.demo.sevice.implementation;

import com.example.demo.entity.Client;
import com.example.demo.entity.DTO.DevisCreateDto;
import com.example.demo.entity.DTO.DevisPaginationDto;
import com.example.demo.entity.DTO.ProduitDevisDto;
import com.example.demo.entity.Devis;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProduitDevis;
import com.example.demo.respository.ClientRepository;
import com.example.demo.respository.DevisRepository;
import com.example.demo.respository.ProductRepository;
import com.example.demo.respository.ProduitDevisRepository;
import com.example.demo.sevice.definir.DevisService;
import com.example.demo.sevice.definir.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final ProduitDevisRepository produitDevisRepository;
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
    @Transactional
    public Devis createDevis( DevisCreateDto devisCreateDto) {
        // Vérification de la nullité de "cassier"
        if (devisCreateDto.cassier() == null || devisCreateDto.cassier().isEmpty()) {
           throw new RuntimeException("Cassier cannot be null or empty");
        }

        // Récupérer les entités client par leurs ID
        Client client = clientRepository.findById(devisCreateDto.clientId())
               .orElseThrow(() -> new RuntimeException("Client not found"));

//        creer une liste de vide des produitdevis selectionné pr lutilisateur
        List<ProduitDevis> produitDevis = new ArrayList<>();


        // Créer un nouvel objet Devis
        Devis devis =new Devis();
        devis.setClient(client);
        devis.setTotalTHt(devisCreateDto.totalTHt());
        devis.setReduction(devisCreateDto.reduction());
        devis.setTotalTva(devisCreateDto.totalTva());
        devis.setDate(devisCreateDto.date());
        devis.setCassier(devisCreateDto.cassier());
        devis.setProduitDevis(new ArrayList<>());

        //save le devis
        Devis saveDevis = devisRepository.save(devis);
//        pour chaque produit de la liste selectionne par lutilisateur
        devisCreateDto.productDevis().forEach(produitDevisDto -> {
//            recuperer lid de chaque produit
            UUID pdtId = produitDevisDto.getProduct().getProductId();
            Product product = productRepository.findById(pdtId).get();

//            apres avoir recupere lid de chaque produit de la liste construis le nouvel objet produit
//            qui devient newproduitdevis et sera enregistré dans sa liste

            ProduitDevis newProduitDevis = ProduitDevis.builder()
                    .qte(produitDevisDto.getQte())
                    .product(product)
                    .devis(saveDevis)
                    .build();
//            on save le nouveau produitDevis
            produitDevisRepository.save(newProduitDevis);
//on lajout dans la liste de produitdevis pour la save
            produitDevis.add(newProduitDevis);
        });

        saveDevis.setProduitDevis(produitDevis);

//        on save donc le devis
        return devisRepository.save(saveDevis);
    };



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
