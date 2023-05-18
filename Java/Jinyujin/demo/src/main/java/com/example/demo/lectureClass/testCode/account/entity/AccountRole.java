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

    @ManyToOne
    @Getter
    private TestAccount account;
    // 나는 Account에서 manyToOne을 달았는데 쌤은 여기서 달았네
    // manyToOne에 대해 물어보자
    // account 테이블에 사업자, 관리자, 일반 회원이 있으니까
    // role이 1로, account가 many로 묶이는 것

    public AccountRole(String role, TestAccount account) {
        this.role = role;
        this.account = account;
    }
}
