package com.example.demo.lectureClass.testCode.account.entity;

import com.example.demo.lectureClass.testCode.homework.junit2.accountRole.entity.AccountRoleHomework;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
public class TestAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "account_role_id")
//    @Setter
//    private AccountRoleHomework accountRole;

    public TestAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
