package com.example.demo.controlleur;

import com.example.demo.entity.Client;
import com.example.demo.entity.DTO.ClientCreateDto;
import com.example.demo.sevice.definir.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @DeleteMapping("delete/{clientId}")
    public void deleteClient(@PathVariable UUID clientId){this.clientService.deleteClient(clientId);}

    @PostMapping("update")
    public void updateClient(Client client){this.clientService.updateClient(client);}
}
