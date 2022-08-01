package com.example.tech.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long accountId;

    private Long number;
    private Short type;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Account(Long number, Short type, Boolean status, Client client) {
        this.number = number;
        this.type = type;
        this.status = status;
        this.client = client;
    }

    public Account() {
        //
    }
}
