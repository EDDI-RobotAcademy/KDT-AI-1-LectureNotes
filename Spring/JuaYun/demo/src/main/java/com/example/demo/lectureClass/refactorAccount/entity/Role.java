package com.example.demo.lectureClass.refactorAccount.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    // Enum 을 문자열로 매핑하기 위한 어노테이션
    private RoleType roleType;

    public Role(RoleType roleType) {
        this.roleType = roleType;
    } // 생성자

    public RoleType getRoleType() {
        return roleType;
    } // getter 생성
}
