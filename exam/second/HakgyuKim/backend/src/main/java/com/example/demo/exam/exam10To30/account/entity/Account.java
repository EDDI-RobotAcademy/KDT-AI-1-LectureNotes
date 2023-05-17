package com.example.demo.exam.exam10To30.account.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToOne(mappedBy = "account")
    private AccountRole accountRole;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
