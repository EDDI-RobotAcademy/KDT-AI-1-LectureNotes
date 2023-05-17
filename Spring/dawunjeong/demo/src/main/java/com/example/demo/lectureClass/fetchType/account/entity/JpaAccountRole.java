package com.example.demo.lectureClass.fetchType.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class JpaAccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @ManyToOne(fetch =  FetchType.LAZY)
    private JpaAccount account;

    public JpaAccountRole(String role, JpaAccount account) {
        this.role = role;
        this.account = account;
    }

}
