package homework.classPractice.game;


class Game { // 굳이 필요한가
    final int GAME_ROUND;

    public Game(final int ROUND) {
        this.GAME_ROUND = ROUND;
    }
}

class Dice2 {
    final int MIN = 1;
    final int MAX = 6;
    final int diceNumber;

    public Dice2() {
        this.diceNumber = (int)(Math.random() * (MAX - MIN + 1) + MIN) ;
    }
    public int getDiceNumber() {
        return this.diceNumber;
    }
}

class Score {
    final int scoreSum;

    public Score(int s1, int s2, int s3, int s4) {
        this.scoreSum = s1 + s2 + s3 + s4;
    }

    public int getScoreSum() {
        return this.scoreSum;
    }
}

public class DiceClassTest {
    public static void main(String[] args) {
        final int TO_WIN1 = 3;
        final int TO_WIN2 = 4;
        final int DICE_COUNT = 4;
        int result = 0;

        final Game game = new Game(2);

        for (int i = 0; i < game.GAME_ROUND; i++) {
            final Dice2 dice1 = new Dice2();
            final Dice2 dice2 = new Dice2();
            final Dice2 dice3 = new Dice2();
            final Dice2 dice4 = new Dice2();

            final Score scoreSum = new Score(dice1.getDiceNumber(),
                                             dice2.getDiceNumber(),
                                             dice3.getDiceNumber(),
                                             dice4.getDiceNumber());

            for (int j = 0; j < DICE_COUNT; j++) {
                result = scoreSum.getScoreSum();
            }
            System.out.printf("제 %d 라운드 결과: %d, %d, %d, %d\n", i + 1, dice1.getDiceNumber(),
                                                              dice2.getDiceNumber(),
                                                              dice3.getDiceNumber(),
                                                              dice4.getDiceNumber());
            System.out.println("주사위의 합 = " + result);
            if (result % TO_WIN1 == 0 || result % TO_WIN2 == 0) {
                System.out.println("승리\n");
            }
            else {
                System.out.println("패배\n");
            }
        }
    }
}
