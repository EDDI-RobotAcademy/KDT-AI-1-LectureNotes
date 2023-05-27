package com.example.demo.exam.exam10To30.account.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String businessNumber;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public AccountRole(Account account, Role role, String businessNumber) {
        this.account = account;
        this.role = role;
        this.businessNumber = businessNumber;
    }
}
