package com.example.demo.exam.accountTest.entity.account;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Account {
    /*
        - Account 클래스에는 AccountRole 을 불러옴
        - accountRole 에 account 를 맵핑
     */

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private AccountRole accountRole;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setAccountRole(AccountRole accountRole) {
        this.accountRole = accountRole;

        accountRole.setAccount(this);
    }
}
