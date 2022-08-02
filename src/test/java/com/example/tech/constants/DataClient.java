package com.example.tech.constants;

import com.example.tech.models.Client;

import java.util.Optional;

public class DataClient {
    public static Optional<Client> createClient001() {
        Client cLient = new Client();
        cLient.setPersonId(1L);
        cLient.setName("jhon");
        cLient.setLastName("Doe");
        cLient.setGender("1");
        cLient.setStatus(true);
        cLient.setPassword("1234");
        cLient.setAge(30);
        cLient.setPhone("0999995555");
        cLient.setAddress("test street 123");
        cLient.setDni("0999999999");
        return Optional.of(cLient);
    }
}
