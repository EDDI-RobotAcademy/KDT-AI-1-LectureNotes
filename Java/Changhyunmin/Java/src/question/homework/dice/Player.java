package question.homework.dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private Score sc;
    final private List<Dice>dice = new ArrayList<>();
    //final private GameDice[] gameDices = new GameDice[MAX_DICE_NUM];
    // 배열을 List로 변환
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
            dice.add(new Dice());
            //dice[i] = new Dice();
            diceNumberSum += dice.get(i).getDiceNumber();

            //dice[i]
            if(dice.get(0).getDiceNumber()%DECISON_EVEN == ODD){
                break;
                //if(dice[FIRST_DICE_INFO].getDiceNumber()%DECISON_EVEN == ODD)
                // = if(dice[0]. getDiceNumber()%2==1)
            }
        }
        return diceNumberSum;
    }

    public Score getSc() {
        return sc;
    }

    public String getName() {
        return name;
    }

    public Dice getSelectedDice(int speclaDiceIndex) {
        return dice.get(speclaDiceIndex);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", sc=" + sc +
                ", dice=" + dice +
                '}';
    }
}