package com.example.demo.test.test10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class TestAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String email;
    @Getter
    private String password;
    @Getter
    private String role;

    public TestAccount(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}