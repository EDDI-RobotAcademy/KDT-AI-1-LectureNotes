package kr.eddi.demo.lectureClass.vue.problem.player;

import kr.eddi.demo.lectureClass.vue.problem.dice.Dice;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Player {
    private List<Dice> diceList;
    private int diceSum;
    private String name;

    public Player(int diceMaxNumber) {
        diceList = new ArrayList<>();

        for (int i = 0; i < diceMaxNumber; i++) {
            diceList.add(new Dice());
        }
    }

    public Player(int diceMaxNumber, int conditionDiceIdx, int nameIdx) {
        diceList = new ArrayList<>();
        diceSum = 0;

        name = "player" + nameIdx;

        final int EVEN_DICISION = 2;
        final int ODD = 1;

        for (int i = 0; i < diceMaxNumber; i++) {
            final Dice dice = new Dice();
            diceList.add(dice);

            diceSum += dice.getDiceNumber();

            if (i == conditionDiceIdx) {
                if (dice.getDiceNumber() % EVEN_DICISION == ODD) {
                    break;
                }
            }
        }
    }

    public Dice getDice (int idx) {
        if (diceList.size() - 1 < idx) {
            return null;
        }

        return diceList.get(idx);
    }

    public void setDiceSum (int score) {
        this.diceSum = score;
    }
}
