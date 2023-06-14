package com.example.demo.Problem10SignIn.entity;

import jakarta.persistence.*;
@Entity
public class AccountBusinessNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "businessNumber_id")
    private BusinessNumber businessNumber;

    public AccountBusinessNumber(Account account, BusinessNumber businessNumber) {
        this.account = account;
        this.businessNumber = businessNumber;
    }
}
