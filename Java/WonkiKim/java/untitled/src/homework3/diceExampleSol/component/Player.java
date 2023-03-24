package homework3.diceExampleSol.component;

// Player에게 필요한게 뭐지?

import java.util.Arrays;

public class Player {
    final private String name;
    final private int MAX_DICE_NUM = 3;

    final private Dice[] diceArray = new Dice[MAX_DICE_NUM];
    final private Score score;


    public Player(String name) {
        this.name = name;
        int diceNumberSum = rollDice();
        score = new Score(diceNumberSum);

    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", diceArray=" + Arrays.toString(diceArray) +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    private int rollDice() {
        final int DECISION_EVEN = 2;
        final int FIRST_DICE_INFO = 0;
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            diceArray[i] = new Dice();

            diceNumberSum += diceArray[i].getDiceNumber();

            if (diceArray[FIRST_DICE_INFO].getDiceNumber() % DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public Dice getSelectedDice(int index) {
        return diceArray[index];
    }

    public Score getScore() {
        return score;
    }
}
