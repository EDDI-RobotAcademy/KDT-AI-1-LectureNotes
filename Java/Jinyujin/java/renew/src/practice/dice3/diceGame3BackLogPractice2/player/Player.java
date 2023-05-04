package practice.dice3.diceGame3BackLogPractice2.player;

import practice.dice3.diceGame3BackLogPractice2.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class Player {

    final private String playerName;
    final private int PLAYER_NUMBER = 2;

    public Player(String palyerName) {
        this.playerName = palyerName;
    }

    public void rollDice() {
        final int FIRST_DICE_NUMBER = 0;

        final List<Dice> diceList = new ArrayList<>();

        for (int i = 0; i < PLAYER_NUMBER; i++) {
            diceList.add(new Dice());

            if (diceList.get(FIRST_DICE_NUMBER).getRandomDiceNumber() % 2 == 1) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                '}';
    }
}
