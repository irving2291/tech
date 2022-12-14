package com.example.tech.services.Impl;

import com.example.tech.models.Client;
import com.example.tech.repositories.ClientRepository;
import com.example.tech.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ArrayList<Client> getAll() {
        return (ArrayList<Client>) clientRepository.findAll();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }

    public Boolean deleteClient(Long id) {
        try {
            clientRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
