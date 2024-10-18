package com.example.demo.controlleur;

import com.example.demo.entity.Client;
import com.example.demo.entity.DTO.ClientCreateDto;
import com.example.demo.sevice.definir.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/client")
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class ClientControlleur {
    private final ClientService clientService;

    public ClientControlleur(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/listeClient")
    public List<Client> getlisteClient(){
        return this.clientService.listeClient();
    }

    @PostMapping("/createClient")
    public ResponseEntity createClient(@RequestBody ClientCreateDto client) {
        System.out.println(client);
        try {
            clientService.createClient(client);
            return ResponseEntity.ok("Client created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }

//    @DeleteMapping("/deleteClient/{clientId}")
//    public ResponseEntity<String> deleteClient(@PathVariable UUID clientId) {
//        try {
//            clientService.deleteClient(clientId);  // Appel du service pour supprimer le client
//            return ResponseEntity.ok("Client supprimé avec succès.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Erreur lors de la suppression du client.");
//        }
//    }
@DeleteMapping("deleteClient/{clientId}")
public ResponseEntity<Void> deleteClient(@PathVariable UUID clientId) {
    // Appeler le service pour supprimer le client de la base de données
    boolean isDeleted = clientService.deleteClient(clientId);

    if (isDeleted) {
        return ResponseEntity.noContent().build(); // 204 si suppression réussie
    } else {
        return ResponseEntity.notFound().build();  // 404 si client non trouvé
    }
}

    @PostMapping("renameClient/")
    public ResponseEntity<String> updateClient(@RequestBody Client client) {
        try {
            clientService.updateClient(client);
            return ResponseEntity.ok("Client renommé avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la mise à jour du client.");
        }
    }
}
