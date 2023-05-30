package com.example.demo.lectureClass.testCode.account.entity;

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
    // @ManyToOne이 붙으면 그 녀석은 해당 Entity의 id 값을 가집니다.
    @ManyToOne
    private TestAccount account;

    public AccountRole(String role, TestAccount account) {
        this.role = role;
        this.account = account;
    }
}
