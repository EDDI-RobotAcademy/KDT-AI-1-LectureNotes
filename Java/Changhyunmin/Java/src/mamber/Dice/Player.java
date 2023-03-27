package mamber.Dice;

import java.util.Arrays;

public class Player {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private Dice[]dice = new Dice[MAX_DICE_NUM];
    final private Score sc;

    public Player(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        sc = new Score(diceNumberSum);
    }
    private int rollDice() {
        final int FIRST_DICE_INFO = 0;
        final int DECISON_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            dice[i] = new Dice();

            diceNumberSum += dice[i].getDiceNumber();

            if(dice[FIRST_DICE_INFO].getDiceNumber()%DECISON_EVEN == ODD){
                break;
            }
        }
        return diceNumberSum;
    }
    public Dice getSelectedDice(int index) {
        return dice[index];
    }

    public Score getSc() {
        return sc;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", dice=" + Arrays.toString(dice) +
                ", sc=" + sc +
                '}';
    }
}

