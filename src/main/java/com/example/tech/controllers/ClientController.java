package com.example.tech.controllers;

import com.example.tech.controllers.request.AccountDTO;
import com.example.tech.controllers.request.ClientTDO;
import com.example.tech.enums.AccountType;
import com.example.tech.enums.EnumTypes;
import com.example.tech.models.Client;
import com.example.tech.services.AccountService;
import com.example.tech.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping()
    public ArrayList<Client> getAll() {
        return clientService.getAll();
    }

    @PostMapping(path = "/create")
    public Client create(@RequestBody Client client) {
        Random rand = new Random();
        client.setPassword(Integer.toString(rand.nextInt(9999)));
        client.setStatus(true);
        return this.clientService.save(client);
    }

    @PatchMapping()
    public Client save(@RequestBody Client client) {
        return this.clientService.save(client);
    }

    @GetMapping(path = "/{id}")
    public Optional<Client> getById(@PathVariable("id") Long id) {
        return this.clientService.getById(id);
    }

    @PatchMapping(path = "/{clientId}")
    public HashMap<String, Object> updateClient(
            @PathVariable("clientId") Long clientId,
            @RequestBody ClientTDO clientTDO) {

        HashMap<String, Object> response = new HashMap<>();
        try {
            Client client = clientService.getById(clientId).get();
            client.setClientDto(clientTDO);
            clientService.save(client);
            response.put("message", "account was updated successful");
            response.put("accountId", clientId);
        } catch (Exception err) {
            response.put("message", err.getMessage());
        }
        return response;
    }

    @DeleteMapping(path = "/{clientId}")
    public HashMap<String, Object> delete(@PathVariable("clientId") Long clientId) {
        HashMap<String, Object> response = new HashMap<>();
        if (clientService.deleteClient(clientId)) {
            response.put("message", "client was delete successful");
        } else {
            response.put("message", "client not delete account");
        }
        return response;
    }
}
