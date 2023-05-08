package practice.dice2.dice2BackLog.playGame;

import practice.dice2.dice2BackLog.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {

    final private List<Dice> diceList = new ArrayList<>();

    public int rollDice() {

        int diceSum = 0;

        for (int i = 0; i < 4; i++) {
            diceList.add(new Dice());
            diceSum += diceList.get(i).getDiceNumber();
        }
        return diceSum;
    }

    @Override
    public String toString() {
        return "PlayGame{" +
                "diceList=" + diceList +
                '}';
    }
}
