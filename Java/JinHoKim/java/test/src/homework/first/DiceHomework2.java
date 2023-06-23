package homework.first;

public class DiceHomework2 {
    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 6;

        final int diceNumber1 = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
        final int diceNumber2 = (int)(Math.random() * (MAX - MIN + 1)) + MIN;

        // 이런 형태에선 어차피 고정값이므로 final이어도 무방
        // 추후 매서드를 설계하더라도 1번(DiceHomework1),
        // 2번(DiceHomework2)를 고려하며 작성하면 좋음
        final int diceNumberSum = diceNumber1 + diceNumber2;

        System.out.println("주사위 굴려서 합친값: " + diceNumberSum);

        final int WINNER_DECISION_NUMBER = 4;

        if (diceNumberSum % WINNER_DECISION_NUMBER == 0) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
    }
}

