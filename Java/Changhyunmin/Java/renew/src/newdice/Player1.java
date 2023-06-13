package newdice;

import java.util.ArrayList;
import java.util.List;

public class Player1 {

    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<Die> dieList = new ArrayList<>();

    final private GameScore gameScore1;

    public Player1(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        gameScore1 = new GameScore(diceNumberSum);
    }

    private int rollDice() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            dieList.add(new Die());

            diceNumberSum += dieList.get(i).getDiceNumber();

            if (dieList.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public Die getSelectedGameDice(int index) {
        return dieList.get(index);
    }

    public GameScore getGameScore() {
        return gameScore1;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player1{" +
                "name='" + name + '\'' +
                ", dieList=" + dieList +
                ", gameScore=" + gameScore1 +
                '}';
    }
}


class Player2 {

    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<Die> dieList = new ArrayList<>();

    final private GameScore gameScore;

    public Player2(String name) {
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
            dieList.get(i);

            diceNumberSum += dieList.get(i).getDiceNumber();

            if (dieList.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public Die getSelectedGameDice(int index) {
        return dieList.get(index);
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player2{" +
                "name='" + name + '\'' +
                ", dieList=" + dieList +
                ", gameScore=" + gameScore +
                '}';
    }
}

