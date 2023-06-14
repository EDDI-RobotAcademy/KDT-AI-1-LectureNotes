package com.example.demo.problem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Account {

    @Id
    @Getter
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Getter
    private String password;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private AccountRole accountRole;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account(AccountRole accountRole) {
        this.accountRole = accountRole;

        accountRole.setAccount(this);
    }
}
