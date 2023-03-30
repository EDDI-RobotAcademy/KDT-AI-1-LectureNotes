package homework.fifth.diceList.four;

import utilityRandom.CustomRandom;

public class FourthDice {
    private final int MAX_NUM=6;
    private final int MIN_NUM=1;
    final int new_Dice;

    public FourthDice() {
        this.new_Dice = (int)(CustomRandom.generateNumber(MIN_NUM,MAX_NUM));
    }

    public int getNew_Dice() {
        return new_Dice;
    }

    @Override
    public String toString() {
        return "ForthDice{" +
                "new_Dice=" + new_Dice +
                '}';
    }
}
