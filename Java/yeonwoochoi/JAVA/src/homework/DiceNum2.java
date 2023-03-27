package homework;

class Game {

}

class Dice2 {
    private int diceNumber;

    public Dice2(int diceNumber) {
        this.diceNumber = diceNumber;
    }

    public Dice2() {
        this.diceNumber = diceNumber;

        final int MAX = 6;
        final int MIN = 1;
        final int WINNER_DECISION_NUMBER1 = 3;
        final int WINNER_DECISION_NUMBER2 = 4;
        final int diceNum1 = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
        final int diceNum2 = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
        final int diceNum3 = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
        final int diceNum4 = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
        final int diceNumSum = diceNum1 + diceNum2 + diceNum3 + diceNum4;

        System.out.println("주사위의 합: " + diceNumSum);

        // 승자 판정
        if (diceNumSum % WINNER_DECISION_NUMBER1 == 0 ||
                diceNumSum % WINNER_DECISION_NUMBER2 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}
public class DiceNum2 {

    public static void main(String[] args) {

        final Dice2 dice2 = new Dice2();
    }
}
