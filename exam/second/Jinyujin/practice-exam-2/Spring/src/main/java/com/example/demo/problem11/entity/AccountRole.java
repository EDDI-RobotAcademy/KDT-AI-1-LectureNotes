package com.example.demo.problem11.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

//@Entity
//@NoArgsConstructor
//public class AccountRole {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private NormalAccount normalAccount;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private BusinessAccount businessAccount;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    private Role role;
//
//    public AccountRole(NormalAccount normalAccount, BusinessAccount businessAccount, Role role) {
//        this.normalAccount = normalAccount;
//        this.businessAccount = businessAccount;
//        this.role = role;
//    }
//}
