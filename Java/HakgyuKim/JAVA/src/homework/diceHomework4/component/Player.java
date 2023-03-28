package homework.diceHomework4.component;

import java.util.ArrayList;
import java.util.List;

public class Player {
    final private String name;
    final private int MAX_DICE_NUM = 3;
    List<Dice> DiceList = new ArrayList<>();
    final private Score score;

    public Player(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        score = new Score(diceNumberSum);
    }

    private int rollDice() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;


        for (int i = 0; i < MAX_DICE_NUM; i++) {
        DiceList.add(new Dice());

            diceNumberSum += DiceList.get(i).getDiceNumber();

            if (DiceList.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        } return diceNumberSum;
    }

    public Dice getSelectedGameDice(int index) {
        return DiceList.get(index);
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }



    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", DiceList=" + DiceList +
                ", score=" + score +
                '}';
    }
}
