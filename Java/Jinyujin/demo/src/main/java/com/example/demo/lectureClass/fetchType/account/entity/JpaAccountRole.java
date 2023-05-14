package com.example.demo.lectureClass.fetchType.account.entity;

import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
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

    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    // 요 부분이 달라짐
    // 이걸 해두면 TestAccount account 이 객체를 안가져온대
    @Getter
    private JpaAccount account;

    public JpaAccountRole(String role, JpaAccount account) {
        this.role = role;
        this.account = account;
    }
}
