package com.example.demo.lectureClass.refactorAccount.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class RefactorAccount {

    @Id
    @Column(name = "refactor_account_id")
    // 해당 필드가 DB의 refactor_account_id 와 매핑됨을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    // RefactorAccountRole 과 1대1 매핑되며, account 필드에 의해 매핑
    private RefactorAccountRole refactorAccountRole;

    public RefactorAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setAccountRole(RefactorAccountRole accountRole) {
        this.refactorAccountRole = accountRole;

        accountRole.setAccount(this);
    }
}
