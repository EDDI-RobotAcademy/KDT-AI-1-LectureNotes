package practice.practice1;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Dice {

    // 주사위 생성 - for문
    final private List<Integer> diceList = new ArrayList<>();
    int diceNumber;
    int diceNumberSum;

    public List<Integer> getDiceList() {
        return diceList;
    }

    public Dice() {
        final int MAX_DICE_NUMBER = 6;
        final int MIN_DICE_NUMBER = 1;
        final int MAX_DICE_COUNT = 3;

        for (int i = 0; i < MAX_DICE_COUNT; i++) {
            diceNumber = CustomRandom.generateNumber(
                    MIN_DICE_NUMBER, MAX_DICE_NUMBER);
            diceList.add(diceNumber);
            diceNumberSum += diceList.get(i);
        }
    }

    public void rollDice() {
        // 주사위 규칙
        // 첫 번째 주사위가 짝수면 나머지 2개를 굴릴 수 있음 - for 문과 if 문
        final int ODD = 1;
        final int playerNumber = 2;

        for (int i = 0; i < playerNumber; i++) {
            if (diceNumber % 2 == ODD) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceList=" + diceList +
                ", diceNumberSum=" + diceNumberSum +
                '}';
    }
}