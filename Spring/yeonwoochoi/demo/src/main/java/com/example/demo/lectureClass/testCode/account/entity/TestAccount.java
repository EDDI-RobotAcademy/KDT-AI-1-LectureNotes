package com.example.demo.lectureClass.testCode.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter // 필요한 경우에만 넣음
@Entity
@NoArgsConstructor
public class TestAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    public TestAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
}