package homework.fifth.diceList.four;

import homework.third.GameDice;
import homework.third.GameScore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourthPlayer {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    private final List<FourthDice> gameDice =new ArrayList<>();


    FourthScore fourthScore;

    public FourthPlayer(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        fourthScore = new FourthScore((diceNumberSum);
    }

    private int rollDice() {

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            gameDice.add(new FourthDice());

            diceNumberSum += gameDice.get(i).getNew_Dice();

            if (gameDice.get(0).getNew_Dice()%2==1){
                break;
            }
        }

        return diceNumberSum;
    }

    public FourthDice getSelectedGameDice(int index) {
        return gameDice.get(index);
    }
    public FourthScore getGameScore(){
        return fourthScore;
    }
    public String getName(){
        return name;

    }

    @Override
    public String toString() {
        return "FourthPlayer{" +
                "name='" + name + '\'' +
                ", gameDice=" + gameDice +
                ", fourthScore=" + fourthScore +
                '}';
    }
}
