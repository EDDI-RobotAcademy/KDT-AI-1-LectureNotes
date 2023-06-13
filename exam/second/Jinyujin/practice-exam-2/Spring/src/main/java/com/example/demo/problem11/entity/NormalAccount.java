package com.example.demo.problem11.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class NormalAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "account_id")
    private Long id;

    private String email;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    public NormalAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
