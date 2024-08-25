package com.example.demo.sevice.implementation;

import com.example.demo.entity.Client;
import com.example.demo.respository.ClientRepository;
import com.example.demo.sevice.definir.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void createClient(Client client ) {
        //verifier sil le client quon veux creer existe deja
//        Optional<Client> existeClient = clientRepository.findById(client.getClientId());
//        if(existeClient.isPresent()){
//            //CLIENT EXISTE
//            throw new RuntimeException("Client already exists with email: " + client.getClientId());        }
//        else{
//            this.clientRepository.save(client);
//        }
        this.clientRepository.save(client);
//        this.clientRepository.save(devis);
    }

    @Override
    public void deleteClient(Long clientId) {
        this.clientRepository.deleteById(clientId);
    }

    @Override
    public void updateClient(Client client) {
        this.clientRepository.save(client);

    }

    @Override
    public Client getClient(Long clientId) {
        return null;
    }


}
