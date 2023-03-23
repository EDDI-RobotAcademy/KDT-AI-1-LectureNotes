package homework.second;

import java.util.Arrays;

class Dice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;
    public Dice () {
    this.diceNumber = (int) (Math.random() * (MAX - MIN +1)) +MIN;
    }
    public int getDiceNumber () {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}

class Game {
    final private int MAX_DICE = 4;
    final private Dice[] diceArray;
    final private Score score;

    public Game () {
        this.diceArray = new  Dice[MAX_DICE];
        int diceNumberSum = 0;

        for (int i = 0; i < diceArray.length; i++) {
            diceArray[i] = new Dice();
            diceNumberSum += diceArray[i].getDiceNumber();
        }

        this.score = new Score(diceNumberSum);
    }
    public Boolean checkWin () {
        return score.checkWin();
    }
    @Override
    public String toString() {
        return "Game{" +
                "diceArray=" + Arrays.toString(diceArray) +
                '}';
    }

    class Score {
        final private int WIN_DECISION1 = 3;
        final private int WIN_DECISION2 = 4;
        final private int totalScore;

        public Score (int totalScore) {
            this.totalScore = totalScore;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "totalScore=" + totalScore +
                    '}';
        }

        public Boolean checkWin () {
            if ((totalScore % WIN_DECISION1 == 0) ||
                    (totalScore % score.WIN_DECISION2 == 0)) {
                return true;
            }
            return false;
        }
    }


}





    public class Dice2 {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game);
        System.out.println(game.checkWin() ? "승리" : "패배");
        }
    }
