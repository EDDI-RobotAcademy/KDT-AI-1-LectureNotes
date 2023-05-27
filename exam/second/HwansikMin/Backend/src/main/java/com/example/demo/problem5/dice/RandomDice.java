package com.example.demo.problem5.dice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RandomDice {
    final private static int MIN = 1;
    final private static int MAX = 6;
    final private static int diceNumber;

    public RandomDice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }
}
