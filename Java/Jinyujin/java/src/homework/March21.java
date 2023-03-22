package homework;

public class March21 {
    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 6;

        int diceNum1 = (int)(Math.random() * MAX - MIN + 1) + MIN;
        int diceNum2 = (int)(Math.random() * MAX - MIN + 1) + MIN;

        final int diceNumSum = diceNum1 + diceNum2;

        System.out.println("첫 번째 주사위 결과 = " + diceNum1);
        System.out.println("두 번째 주사위 결과 = " + diceNum2);

        System.out.println("두 주사위의 합 = " + diceNumSum);

        final int WINNER_DECISION_NUMBER = 4;

        if (diceNumSum % WINNER_DECISION_NUMBER == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}
