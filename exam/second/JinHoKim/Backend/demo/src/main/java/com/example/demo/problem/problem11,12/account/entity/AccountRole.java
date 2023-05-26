package com.example.demo.problem.problem11.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @Getter
    @ManyToOne
    private com.example.demo.problem.problem11.account.entity.TestAccount account;

    public AccountRole(String role, com.example.demo.problem.problem11.account.entity.TestAccount account) {
        this.role = role;
        this.account = account;
    }
}