package com.example.demo.controller.lectureClass.homework.problem2;

import com.example.demo.controller.lectureClass.utility.CustomRandom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class MyCharacterStatusForm {

    // vue 에서 생성한 코드를 form 위치에 필요한 것을 구성해주고
    // controller 쪽에서 해결하게 만들기
    final private int MIN = 70;
    final private int MAX = 150;
    final private int START = 30;
    final private int END = 50;

    private int hp = CustomRandom.generateNumber(MIN, MAX);
    private int strength = CustomRandom.generateNumber(START, END);
    private int intelligent = CustomRandom.generateNumber(START, END);
    private int dexterity = CustomRandom.generateNumber(START, END);
    private int agility = CustomRandom.generateNumber(START, END);
}
