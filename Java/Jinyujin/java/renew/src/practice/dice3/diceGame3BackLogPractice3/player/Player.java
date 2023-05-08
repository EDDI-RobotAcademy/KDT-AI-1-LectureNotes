package practice.dice3.diceGame3BackLogPractice3.player;

import practice.dice3.diceGame3BackLogPractice3.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class Player {

    final private String name;
    final private int DICE_MAX = 3;
    final private List<Dice> diceList = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void rollDice() {

        int diceSum = 0;

        for (int i = 0; i < DICE_MAX; i++) {
            diceList.add(new Dice());
            // Dice의 생성자와 연결되는 것
            diceSum += diceList.get(i).getDiceNumber();
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", diceList=" + diceList +
                '}';
    }
}
