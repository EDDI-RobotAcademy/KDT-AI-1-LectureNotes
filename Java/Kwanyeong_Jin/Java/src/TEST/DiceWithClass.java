package TEST;

import java.util.Arrays;

class Dice_GAME extends Score {
    public int Sum;
    final public Score score = new Score();

    public Dice_GAME(){
        this.Sum = score.getSum();
    }

    public String getResult() {
        String eachDice = String.format("1번째 주사위의 값은 %d이고 2번째 주사위의 값은 %d이고\n" +
                "3번째 주사위의 값은 %d이고 4번째 주사위의 값은 %d입니다.\n",
                diceNum[0].getResNum(), diceNum[1].getResNum(), diceNum[2].getResNum(), diceNum[3].getResNum(), Sum);
        if (Sum % 4 == 0 || Sum % 3 == 0) {
          String totalResult = String.format("네 주사위에 합이 %d이므로 3 또는 4배의 배수에 해당되어 승리하였습니다.", Sum);
            return eachDice + totalResult;
        } else {
          String totalResult = String.format("네 주사위에 합이 %d이므로 3 또는 4배의 배수에 해당되지 않아 패배하였습니다.", Sum);
            return eachDice + totalResult;
        }
    }
}
class Dice {
    final int MAX = 6;
    final int MIN = 1;
    public Dice() {
    }
    public int getResNum() {
        int DiceRes = (int)(Math.random() * MAX) + MIN;
        return DiceRes;
    }
}
class Score {
    public Dice[] diceNum;
    final private int MAX_DICE = 4;
    int score =0;

    public Score(){
        this.diceNum = new Dice[MAX_DICE];
        for (int i = 0; i < MAX_DICE; i++) {
            diceNum[i] = new Dice();
            score += diceNum[i].getResNum();
        }
    }

    public int getSum(){
        return score;
    }
}
public class DiceWithClass {
    public static void main(String[] args) {
        final Dice_GAME test = new Dice_GAME();
        System.out.println(test.getResult());
    }
}
