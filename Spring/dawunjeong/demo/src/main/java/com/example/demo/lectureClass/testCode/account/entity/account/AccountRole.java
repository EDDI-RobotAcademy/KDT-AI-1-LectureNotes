package com.example.demo.lectureClass.testCode.account.entity.account;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @Getter
    @ManyToOne
    private TestAccount testAccount;

    public AccountRole(String role, TestAccount testAccount) {
        this.role = role;
        this.testAccount = testAccount;
    }
}
