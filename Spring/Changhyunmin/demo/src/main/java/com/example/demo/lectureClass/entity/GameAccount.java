package com.example.demo.lectureClass.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class GameAccount {
    private Long id;
    private String email;
    private String password;
}
