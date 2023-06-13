package com.example.demo.Problem10SignIn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class BusinessNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int businessNumber;

    public BusinessNumber(int businessNumber) {
        this.businessNumber = businessNumber;
    }

}
