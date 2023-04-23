package com.example.demo.lectureClass.homework.problem.problem5.teacher;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class GameAccount {

    private Long id;
    private String email;
    private String password;

    public GameAccount(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
