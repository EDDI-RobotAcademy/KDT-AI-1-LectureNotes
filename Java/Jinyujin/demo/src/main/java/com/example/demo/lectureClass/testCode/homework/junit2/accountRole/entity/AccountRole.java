package com.example.demo.lectureClass.testCode.homework.junit2.accountRole.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountRoleId;

    @Getter
    private String role;

    public AccountRole(String role) {
        this.role = role;
    }
}
