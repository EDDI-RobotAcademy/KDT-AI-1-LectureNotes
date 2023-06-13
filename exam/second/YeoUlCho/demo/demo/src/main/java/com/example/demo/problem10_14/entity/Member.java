package com.example.demo.problem10_14.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;
    private String email;
    private String password;
    private Integer businessNumber;

    public Member(String name, String email, String password, Integer businessNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.businessNumber=businessNumber;
    }

    public void setAccountRole(MemberRole memberRole) {
    }
}
