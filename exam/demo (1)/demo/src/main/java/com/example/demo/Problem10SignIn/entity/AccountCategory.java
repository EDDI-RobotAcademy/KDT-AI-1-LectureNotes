package com.example.demo.Problem10SignIn.entity;

import jakarta.persistence.*;

@Entity
public class AccountCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    public AccountCategory(Account account, Category category) {
        this.account = account;
        this.category = category;
    }
}
