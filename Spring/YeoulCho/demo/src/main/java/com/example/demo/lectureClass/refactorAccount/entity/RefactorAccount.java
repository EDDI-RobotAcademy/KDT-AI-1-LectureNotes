package com.example.demo.lectureClass.refactorAccount.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class RefactorAccount {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToOne(mappedBy = "refactorAccount", fetch = FetchType.LAZY)
    private RefactorAccountRole refactorAccountRole;

    public RefactorAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setAccountRole(RefactorAccountRole accountRole) {
        this.refactorAccountRole = accountRole;

        accountRole.setRefactorAccount(this);
    }
}
