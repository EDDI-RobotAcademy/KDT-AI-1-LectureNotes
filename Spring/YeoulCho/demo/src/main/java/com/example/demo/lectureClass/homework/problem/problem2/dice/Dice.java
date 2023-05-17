package com.example.demo.lectureClass.homework.problem.problem2.dice;

import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor //초기화
public class Dice {
    final private int MIN =1;
    final private int MAX =6;
    final private int diceNumber;

    public Dice(){
        this.diceNumber = CustomRandom.generateNumber(MIN,MAX);
    }
}
