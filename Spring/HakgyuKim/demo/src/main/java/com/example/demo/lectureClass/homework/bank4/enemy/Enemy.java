package com.example.demo.lectureClass.homework.bank4.enemy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
@Setter
public class Enemy {
    final private String name = "고블린";
    private int health = 20;
}
