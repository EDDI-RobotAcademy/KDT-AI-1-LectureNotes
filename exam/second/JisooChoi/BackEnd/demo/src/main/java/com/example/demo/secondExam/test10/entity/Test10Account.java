package com.example.demo.secondExam.test10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Test10Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private Integer password;
    private String role;
    private Integer managerRoleNum;

    public Test10Account(String email, Integer password, String role, Integer managerRoleNum) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.managerRoleNum = managerRoleNum;
    }
}
