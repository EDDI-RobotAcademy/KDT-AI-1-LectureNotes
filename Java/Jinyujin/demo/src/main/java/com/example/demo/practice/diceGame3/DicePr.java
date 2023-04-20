package com.example.demo.practice.diceGame3;

import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class DicePr {
    final private static int MIN = 1;
    final private static int MAX = 6;
    final private int diceNumber;

    public DicePr() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }
}
