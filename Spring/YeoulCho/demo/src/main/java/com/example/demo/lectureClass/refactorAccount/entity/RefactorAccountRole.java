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
    @JoinColumn(name = "account_id")
    private RefactorAccount refactorAccount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    public RefactorAccountRole(RefactorAccount refactorAccount, Role role) {
        this.refactorAccount = refactorAccount;
        this.role = role;
    }
}
