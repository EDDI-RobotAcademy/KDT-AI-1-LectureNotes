package math;

public class HomeworkDiceGame1 {
    public static void main(String[] args) {

                final int MAX = 6;
                final int MIN = 1;
                final int WINNER_DECISION_NUMBER = 4;
                final int diceNum1 = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
                final int diceNum2 = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
                final int diceNumSum = diceNum1 + diceNum2;

                System.out.println("두 주사위의 합: " + diceNumSum);

                if (diceNumSum % WINNER_DECISION_NUMBER == 0) {
                    System.out.println("승리");
                } else {
                    System.out.println("패배");
                }

    }
}
