package homework.fifth.diceList;

import homework.third.Player;
import utilityRandom.CustomRandom;

import java.util.ArrayList;
import java.util.List;


public class dice3 {
    public static void main(String[] args) {
        final int MAX_NUM=3;
        List<diceRolling> diceRollingList=new ArrayList<>();
        for (int i=0; i<MAX_NUM;i++){
            diceRollingList.add(new diceRolling(DiceEnum.DicecheckPatternIndex(CustomRandom.generateNumber(1,6))));
        }
        System.out.println(diceRollingList);

    }
}
