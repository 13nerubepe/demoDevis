package com.example.demo.sevice.definir;

import com.example.demo.entity.Client;
import com.example.demo.entity.DTO.ClientCreateDto;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    List<Client> listeClient();

    void createClient(ClientCreateDto client);

    boolean deleteClient(UUID clientId);

    void updateClient(Client client);

    Client getClient(UUID clientId);
}
