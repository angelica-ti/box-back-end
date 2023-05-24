package com.saper.boxbackend.model;

import com.saper.boxbackend.dto.ClientRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String login;

    String email;

    String password;

    public Client() {
    }

    public Client(ClientRequestDTO clientRequestDTO){
        this.login = clientRequestDTO.login;
        this.password = clientRequestDTO.password;
        this.name = clientRequestDTO.name;
        this.email = clientRequestDTO.email;
    }
//    public Client(Long id, String name, String login, String email, String password) {
//        this.id = id;
//        this.name = name;
//        this.login = login;
//        this.email = email;
//        this.password = password;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}