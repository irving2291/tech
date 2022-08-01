package com.example.tech.controllers;

import com.example.tech.models.Client;
import com.example.tech.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping()
    public ArrayList<Client> getAll() {
        return clientService.getAll();
    }

    @PostMapping()
    public Client save(@RequestBody Client client) {
        return this.clientService.save(client);
    }

    @GetMapping(path = "/{id}")
    public Optional<Client> getById(@PathVariable("id") Long id) {
        return this.clientService.getById(id);
    }


}
