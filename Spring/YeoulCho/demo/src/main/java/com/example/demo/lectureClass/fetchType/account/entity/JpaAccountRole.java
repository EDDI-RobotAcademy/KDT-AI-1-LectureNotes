package com.example.demo.lectureClass.fetchType.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString(exclude = {"account"})
// account는 Lazy로 인해 감춰져 있어야하는데 log.info로 accountRole 정보를 확인하려다 보니 에러가 발생
// 고로 account는 제외하고 ToString해야 에러가 나지 않음
@NoArgsConstructor
public class JpaAccountRole {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    private JpaAccount account;

    public JpaAccountRole(String role, JpaAccount account) {
        this.role = role;
        this.account = account;
    }
}
