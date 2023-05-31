package com.example.demo.test.test10.entity;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class AccountWithBusinessNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer businessNumber;

    @ManyToOne
    private TestAccount account;

    public AccountWithBusinessNumber(Integer businessNumber, TestAccount account) {
        this.businessNumber = businessNumber;
        this.account = account;
    }
}
