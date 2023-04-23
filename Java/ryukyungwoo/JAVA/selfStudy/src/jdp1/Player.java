package jdp1;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Dice> diceList;
    final private int HOW_MANY_DICES = 3;
    private int score;
    public Player () {
        score = 0;
        diceList = new ArrayList<>();
        for (int i = 0; i < HOW_MANY_DICES; i++) {
            if (new DecisionDice().DecisionFirstDice() == true) {
            diceList.add(new Dice());}
            else {
                break;
            }
            score += diceList.get(i).getDiceNumber();
        }
    }
    public List<Dice> getDiceList() {

        return diceList;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "diceList=" + diceList +
                ", score=" + score +
                '}';
    }
}
