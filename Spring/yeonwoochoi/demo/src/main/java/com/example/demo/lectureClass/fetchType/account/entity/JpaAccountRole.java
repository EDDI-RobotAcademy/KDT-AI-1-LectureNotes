package com.example.demo.lectureClass.fetchType.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString(exclude = {"account"})
@NoArgsConstructor
public class JpaAccountRole {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 고유하다. 식별이 가능하다.
    private Long id;

    private String role;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY) // @ManyToOne 다 : 1 // (fetch = FetchType.LAZY) account 속성을 막는 용도
    private JpaAccount account;

    public JpaAccountRole(String role, JpaAccount account) {
        this.role = role;
        this.account = account;
    }
}
