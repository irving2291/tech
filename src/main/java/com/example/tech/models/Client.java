package com.example.tech.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client extends Person {

    private String password;
    private Boolean status;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
