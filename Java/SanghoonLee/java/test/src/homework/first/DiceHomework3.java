package homework.first;

public class DiceHomework3 {
    // 가공된 버전을 좋아하는 분들이 있는 것 같음.
    public static void main(String[] args) {

        final int MIN = 1;
        final int MAX = 6;

        final int START = 1;
        final int END = 100;

        for (int i = START; i < END; i++) {

            final int diceNumber1 = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
            final int diceNumber2 = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
            final int diceNumberSum = diceNumber1 + diceNumber2;

            System.out.println("주사위 굴려서 합친값: " + diceNumberSum);

            final int WINNER_DECISION_NUMBER = 4;

            if (diceNumberSum % WINNER_DECISION_NUMBER == 0) {
                System.out.println("현재 판수: " + i + ", 승리!");
            } else {
                System.out.println("현재 판수: " + i + ", 패배!");
            }

        }
    }
}
