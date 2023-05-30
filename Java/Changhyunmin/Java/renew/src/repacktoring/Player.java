package repacktoring;

import java.util.ArrayList;
import java.util.List;

class Player {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    List<Dice> diceList = new ArrayList<>();
    final private Score score;

    public Player(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        score = new Score(diceNumberSum);
    }

    private int rollDice() {
        final int First = 0;
        final int Eden = 2;
        final int ODD = 1;

        int diceNumberSum = 0;
        for (int i = 0; i < MAX_DICE_NUM; i++) {
            diceList.add(new Dice(i));

            diceNumberSum = diceList.get(i).getDiceNumber();

            if (diceList.get(First).getDiceNumber() % Eden == ODD) {
                break;
            }
        }
        return diceNumberSum;
    }

    public String getName() {
        return name;
    }

    public List<Dice> getDiceList(int index) {
        return (List<Dice>) diceList.get(index);
    }

    public Score getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", diceList=" + diceList +
                ", score=" + score +
                '}';
    }
}
