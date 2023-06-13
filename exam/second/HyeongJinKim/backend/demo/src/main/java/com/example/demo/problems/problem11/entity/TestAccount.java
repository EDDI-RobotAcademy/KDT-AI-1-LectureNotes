package com.example.demo.problems.problem11.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class TestAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String role;
    private Long businessNumber;

    public TestAccount(String email, String password, String role, Long businessNumber) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.businessNumber = businessNumber;
    }
}
