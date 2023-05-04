package kr.eddi.demo.vue.problem.dice;

import kr.eddi.demo.utility.CustomRandom;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Dice {

    final private static int MIN = 1;
    final private static int MAX = 6;
    final private int diceNumber;

    public Dice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

}