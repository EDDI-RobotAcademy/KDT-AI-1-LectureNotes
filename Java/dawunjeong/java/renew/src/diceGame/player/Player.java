package diceGame.player;

import diceGame.game.Dice;
import diceGame.game.GameScore;

import java.util.Arrays;

// Player(플레이어)에게 필요한게 뭐지 ?
public class Player {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private Dice[] gameDices = new Dice[MAX_DICE_NUM];
    final private GameScore gameScore;

    public Player(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        gameScore = new GameScore(diceNumberSum);
    }

    private int rollDice() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            gameDices[i] = new Dice();

            diceNumberSum += gameDices[i].getDiceNumber();

            if (gameDices[FIRST_DICE_INFO].getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public Dice getSelectedGameDice(int index) {
        return gameDices[index];
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gameDices=" + Arrays.toString(gameDices) +
                ", gameScore=" + gameScore +
                '}';
    }
}