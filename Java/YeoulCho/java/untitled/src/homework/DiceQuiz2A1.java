package homework;

import java.util.Arrays;

class Dice4{
    final private int MAX = 6;
    final private int MIN = 1;
    final private int WIN_DECISION1 = 3;
    final private int WIN_DECISION2 = 4;
    final int MAX_DICE = 4;
    final int[] diceNumberArr = new int[MAX_DICE];
    final int totalScore;

    public Dice4(){
        int diceNumberSum = 0;

        for (int i =0 ; i<diceNumberArr.length; i++){
            diceNumberArr[i] = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
            diceNumberSum += diceNumberArr[i];
        }

        this.totalScore = diceNumberSum;
    }

    public boolean checkWin(){
        if((totalScore % WIN_DECISION1 == 0)||
            (totalScore % WIN_DECISION2 ==0)) {
            return true;
        }

        return false;

    }

    @Override
    public String toString() {
        return "Dice4{" +
                "diceNumberArr=" + Arrays.toString(diceNumberArr) +
                ", totalScore=" + totalScore +
                '}';
    }
}

public class DiceQuiz2A1 {
    public static void main(String[] args) {
        Dice4 dice = new Dice4();
        System.out.println(dice);
        System.out.println(dice.checkWin() ?  "승리" : "패배");
    }
}
