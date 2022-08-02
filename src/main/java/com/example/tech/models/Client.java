package com.example.tech.models;

import com.example.tech.controllers.request.ClientTDO;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class Client extends Person {

    private String password;
    private Boolean status;

    @OneToMany(mappedBy = "client")
    @OnDelete(action = OnDeleteAction.CASCADE)
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

    public void setClientDto(ClientTDO clientTDO) {
        if (clientTDO.getName() != null) {
            this.setName(clientTDO.getName());
        }
        if (clientTDO.getLastName() != null) {
            this.setLastName(clientTDO.getLastName());
        }
        if (clientTDO.getAge() != null) {
            this.setAge(clientTDO.getAge());
        }
        if (clientTDO.getGender() != null) {
            this.setGender(clientTDO.getGender());
        }
        if (clientTDO.getPhone() != null) {
            this.setPhone(clientTDO.getPhone());
        }
        if (clientTDO.getStatus() != null) {
            this.setStatus(clientTDO.getStatus());
        }
        if (clientTDO.getPassword() != null) {
            this.setPassword(clientTDO.getPassword());
        }
    }
}
