package com.example.demo.lectureClass.refactorAccount.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class RefactorAccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    // RefactorAccount 엔티티와 1대1 매핑
    @JoinColumn(name = "refactor_account_id")
    // refactor_account_id 와 account 가 매핑됨
    private RefactorAccount account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // 필수적으로 Role 엔티티가 존재해야 하므로 optional = false 로 설정해야 한다.
    @JoinColumn(name = "role_id")
    private Role role;

    public RefactorAccountRole(RefactorAccount account, Role role) {
        this.account = account;
        this.role = role;
    }
}

