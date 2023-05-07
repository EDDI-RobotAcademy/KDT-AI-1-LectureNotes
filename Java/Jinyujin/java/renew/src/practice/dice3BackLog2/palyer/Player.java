package practice.dice3BackLog2.palyer;

import practice.dice3BackLog2.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class Player {

    final private String name;

    public Player(String name) {
        this.name = name;
    }

    public void rollDice() {
        final int PLAYER_NUMBER = 2;
        List<Dice> diceList = new ArrayList<>();

        for (int i = 0; i < PLAYER_NUMBER; i++) {
            diceList.add(new Dice());
        }
    }
}
