package com.example.demo.lectureClass.fetchType.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString(exclude = {"account"})
// 요게 몰까? ㅋ
public class JpaAccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @ManyToOne
    // 이거 안붙여서 Bean에러가 계속 떴었음
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    // 요 부분이 달라짐
    // 이걸 해두면 TestAccount account 이 객체를 안가져온대
    private JpaAccount account;

    public JpaAccountRole(Role role, JpaAccount account) {
        this.role = role;
        this.account = account;
    }
}
