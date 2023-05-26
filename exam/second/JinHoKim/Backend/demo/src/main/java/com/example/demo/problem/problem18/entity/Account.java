package com.example.demo.problem.problem18.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Account {

    private Long id;
    private String email;
    private String password;

}