package com.example.demo.lectureClass.manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class TestManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String managerEmail;
    private String managerPassword;

    public TestManager(String managerEmail, String managerPassword) {
        this.managerEmail = managerEmail;
        this.managerPassword = managerPassword;
    }
}
