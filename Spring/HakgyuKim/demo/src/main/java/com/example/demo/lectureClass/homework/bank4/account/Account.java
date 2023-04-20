package com.example.demo.lectureClass.homework.bank4.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Account {

    final private Long id;
    final private String email;
    final private String password;

}
