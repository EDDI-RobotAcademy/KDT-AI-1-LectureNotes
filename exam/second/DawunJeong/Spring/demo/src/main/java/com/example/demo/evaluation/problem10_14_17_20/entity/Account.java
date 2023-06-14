package com.example.demo.evaluation.problem10_14_17_20.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "account")
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private Integer businessNumber;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account(String email, String password, Integer businessNumber) {
        this.email = email;
        this.password = password;
        this.businessNumber = businessNumber;
    }
}
