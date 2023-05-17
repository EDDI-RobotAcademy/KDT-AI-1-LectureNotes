package com.example.demo.Problem10SignIn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<AccountCategory> categories = new HashSet<>();

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private AccountBusinessNumber accountBusinessNumber;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
