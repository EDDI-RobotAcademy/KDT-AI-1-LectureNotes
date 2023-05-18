package com.example.demo.lectureClass.testCode.homework.junit1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class TestMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long memberId;

    @Getter
    String name;
    String email;
    String password;

    public TestMember(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
