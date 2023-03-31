package homework.first;

public class DiceHomework1 {
    public static void main(String[] args) {
        final int START = 0;
        final int DICE_NUMBER = 2;

        final int MIN = 1;
        final int MAX = 6;

        // 여기선 루프 돌면서 갱신하기 때문에 final이 없는 것임.
        int diceNumberSum = 0;

        for (int idx = 0; idx < DICE_NUMBER; idx++) {
            final int diceNumber = (int)(Math.random() * (MAX - MIN + 1)) + MIN;

            diceNumberSum += diceNumber;
            System.out.println("idx: " + idx + ", diceNumber: " + diceNumber);
        }

        System.out.println("주사위 굴려서 합친값: " + diceNumberSum);

        final int WINNER_DECISION_NUMBER = 4;

        if (diceNumberSum % WINNER_DECISION_NUMBER == 0) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
    }
}
