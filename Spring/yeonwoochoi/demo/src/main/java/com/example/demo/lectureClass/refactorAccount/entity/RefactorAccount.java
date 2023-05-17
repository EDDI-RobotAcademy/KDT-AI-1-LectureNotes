package com.example.demo.lectureClass.refactorAccount.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class RefactorAccount {

    @Id
    // @Column은 객체 필드를 테이블의 컬럼에 매핑시켜주는 어노테이션입니다.
    // name 필드와 매핑할 테이블의 컬럼 이름을 지정한다.
    @Column(name = "refactor_account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    // JPA로 연관 관계를 설정할 때 가장 혼동하기 쉬운 부분인데 mappedby는 연관 관계 객체의 반대 객체에 선언합니다.
    // 연관 관계 주인 : "account" 외래키가 있는 객체
    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
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
