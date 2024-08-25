package com.example.demo.sevice.definir;

import com.example.demo.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> listeClient();

    void createClient(Client client);

    void deleteClient(Long clientId);

    void updateClient(Client client);

    Client getClient(Long clientId);
}
