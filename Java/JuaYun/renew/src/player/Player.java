package player;

import diceGame.Dice;
import diceGame.GameScore;

import java.util.ArrayList;
import java.util.List;

// 배열을 리스트형태로 바꿈
public class Player {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<Dice> gameDiceList = new ArrayList<>();
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
            gameDiceList.add(new Dice());

            diceNumberSum += gameDiceList.get(i).getDiceNumber();

            if (gameDiceList.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public Dice getSelectedGameDice(int index) {
        return gameDiceList.get(index);
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
                ", gameDicesList=" + gameDiceList +
                ", gameScore=" + gameScore +
                '}';
    }
}