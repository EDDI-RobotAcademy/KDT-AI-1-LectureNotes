package com.example.demo.problem11.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class BusinessAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "account_id")
    private Long id;

    private String email;
    private String password;
    private String businessNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    public BusinessAccount(String email, String password, String businessNumber) {
        this.email = email;
        this.password = password;
        this.businessNumber = businessNumber;
    }
}
