package com.example.demo.problem10_14.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class TestBusinessMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private Long registNumber;

    public TestBusinessMember(String email, String password, Long registNumber) {
        this.email = email;
        this.password = password;
        this.registNumber = registNumber;
    }
}
