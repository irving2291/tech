package com.example.tech.services;

import com.example.tech.models.Client;

import java.util.ArrayList;
import java.util.Optional;

public interface ClientService {
    ArrayList<Client> getAll();
    Client save(Client client);
    Optional<Client> getById(Long id);
    Boolean deleteClient(Long id);
}
