package com.example.demo.practice.gameCharacter;

import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class CharactetModelForm {

    final static int START = 10;
    final static int END = 20;
    final static int HP_MIN = 70;
    final static int HP_MAX = 150;

    private Integer strength = CustomRandom.generateNumber(START, END);       // 완력
    private Integer intelligent = CustomRandom.generateNumber(START, END);    // 지능
    private Integer dexterity= CustomRandom.generateNumber(START, END);      // 재주
    private Integer agility = CustomRandom.generateNumber(START, END);        // 민첩
    private Integer hp = CustomRandom.generateNumber(HP_MIN, HP_MAX);            // hp
}
