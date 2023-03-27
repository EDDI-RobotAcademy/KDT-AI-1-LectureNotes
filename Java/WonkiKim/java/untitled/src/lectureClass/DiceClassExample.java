package lectureClass;

import java.util.ArrayList;
import java.util.Iterator;

class Dice {
    final private static int DICE_MAX = 6;
    final private static int DICE_MIN = 1;
    final private int diceNumber;

    public Dice() {
        this.diceNumber = (int) (Math.random() * (DICE_MAX - DICE_MIN + 1) + DICE_MIN);
    }

    public int getDiceNumber() {
        return this.diceNumber;
    }
}

class Score {
    final private ArrayList<Integer> scores;

    public Score(final int ITER) {
        scores = new ArrayList<>();
    }

    public void record(final int DICE_NUMBER) {
        scores.add(DICE_NUMBER);
    }

    public int getSumScore() {
        int sum = 0;
        for (final int SCORE : this.scores) {
            sum += SCORE;
        }
        return sum;
    }
}

class Game {
    final private Score score;
    final private int ITER = 4;
    final private int[] WIN_CONDITIONS = {3, 4};

    public Game() {
        score = new Score(ITER);
    }

    public void play() {
        for (int i = 0; i < this.ITER; i++) {
            final Dice dice = new Dice();
            final int DICE_NUMBER = dice.getDiceNumber();

            score.record(DICE_NUMBER);
            System.out.println((i + 1) + "번째 주사위의 눈: " + DICE_NUMBER);
        }
    }

    public void result() {
        final int TOTAL_SCORE = score.getSumScore();

        //승리조건에 부합한다면 if 안의 statement 수행하고 void 리턴.
        //부합하지 않다면 for 문을 끝내고 패배 관련 출력후 메소드 종료.

        for (final int condition : WIN_CONDITIONS) {
            if (TOTAL_SCORE % condition == 0) {
                System.out.println("TOTAL SCORE: " + TOTAL_SCORE + " (으)로 ");
                for (int conditionText : WIN_CONDITIONS) {
                    System.out.print(conditionText + ", ");
                }
                System.out.println("\b\b 중 한 개 이상의 수의 배수이므로 승리입니다");
                return;
            }
        }
        System.out.println("TOTAL SCORE: " + TOTAL_SCORE + "으로 ");
        for (final int conditionText : WIN_CONDITIONS) {
            System.out.print(conditionText + ", ");
        }
        System.out.println("\b\b 중 한 개 이상의 수의 배수가 아니므로 패배입니다.");
    }
}

public class DiceClassExample {
    public static void main(String[] args) {
        final Game game = new Game();
        game.play();
        game.result();
    }
}
