package com.example.demo.problem10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private Long companyNumber;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account(String email, String password, Long companyNumber) {
        this.email = email;
        this.password = password;
        this.companyNumber = companyNumber;
    }
}
