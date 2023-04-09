package _homework_02;

class Dice2 {
//    final int MAX_DICE = 4;
//    final int[] diceNumberArr = new int[MAX_DICE];

    final private int MAX = 6;
    final private int MIN = 1;
    final int WIN_DECISION_NUM1 = 4;
    final int WIN_DECISION_NUM2 = 3;
    final int MAX_DICE = 4;
    final int[] diceNumberArr = new int[MAX_DICE];
    final int totalScore;



    public Dice2() {
        int diceNumberSum = 0;

        for (int i = 0; i < diceNumberArr.length; i++) {
            diceNumberArr[i] = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
            diceNumberSum += diceNumberArr[i];
        }

        this.totalScore = diceNumberSum;
        System.out.println("합계는 " + diceNumberSum + "입니다.");
    }



    public Boolean checkWin() {
        if (totalScore % WIN_DECISION_NUM1 == 0 ||
                totalScore % WIN_DECISION_NUM2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
public class SecondHomework {
    public static void main(String[] args) {
        Dice2 dice = new Dice2();
        System.out.println(dice.checkWin() ? "승리!" : "패배!");
    }
}