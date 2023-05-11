package com.example.demo.lectureClass.testCode.account.entity.consumer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class TestConsumerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    public TestConsumerAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
