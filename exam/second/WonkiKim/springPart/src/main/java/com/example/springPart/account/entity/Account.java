package com.example.springPart.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String role;

    private String businessNumber;

    public Account(String email, String password, String role, String businessNumber) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.businessNumber = businessNumber;
    }
}
