package com.example.demo.sevice.definir;

import com.example.demo.entity.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    List<Client> listeClient();

    void createClient(Client client);

    void deleteClient(String clientId);

    void updateClient(Client client);

    Client getClient(String clientId);
}
