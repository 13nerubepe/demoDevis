package com.example.demo.sevice.implementation;

import com.example.demo.entity.Client;
import com.example.demo.entity.DTO.ClientCreateDto;
import com.example.demo.respository.ClientRepository;
import com.example.demo.sevice.definir.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceI implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceI(ClientRepository clientRepository) {

        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> listeClient() {
        return  this.clientRepository.findAll();
    }

    @Override
    public void createClient(ClientCreateDto clientDto ) {
        //verifier sil le client quon veux creer que son email et son numero existe deja
        if (clientRepository.existsByEmail(clientDto.getEmail())) {
            throw new IllegalArgumentException("L'email est déjà utilisé.");
        }
        // Vérifier si le numéro de téléphone existe déjà
        if (clientRepository.existsByPhone(clientDto.getPhone())) {
            throw new IllegalArgumentException("Le numéro de téléphone est déjà utilisé.");
        }
        Client newClient = Client.builder()
                .nom(clientDto.getNom())
                .phone(clientDto.getPhone())
                .address(clientDto.getAddress())
                .email(clientDto.getEmail())
                .grade(clientDto.getGrade())
                .ville(clientDto.getVille())
                .build();
        clientRepository.findAll().stream().map(client -> ClientCreateDto.toDto(client));
        this.clientRepository.save(newClient);
    }

    @Override
    public void deleteClient(UUID clientId) {

    }

//    @Override
//    public void deleteClient(String clientId) {
//        this.clientRepository.deleteById(clientId);
//    }

    @Override
    public void updateClient(Client client) {
        this.clientRepository.save(client);

    }

    @Override
    public Client getClient(UUID clientId) {
        return null;
    }


}
