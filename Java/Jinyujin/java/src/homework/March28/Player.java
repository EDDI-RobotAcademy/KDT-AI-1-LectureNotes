package homework.March28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<GameDice> gameDices = new ArrayList<>();
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
            gameDices.add(new GameDice());

            diceNumberSum += gameDices.get(i).getDiceNumber();

            if (gameDices.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public GameDice getSelectedGameDice(int index) {
        if (gameDices.size() > index) {
            return gameDices.get(index);
        }
        return null;
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
                ", name='" + name + '\'' +
                ", gameDices=" + gameDices +
                ", gameScore=" + gameScore +
                '}';
    }
}
