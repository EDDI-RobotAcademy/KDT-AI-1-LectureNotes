package HomeWork;

import java.util.Arrays;

class Game {
    final private int MAX_DICE = 4; // 주사위 갯수
    final private Dice[] diceArray; // 주사위 눈금의 배열
    final private Score score; // 점수

    public Game() {
        this.diceArray = new Dice[MAX_DICE];
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
        return "HomeWork.Game{" +
                "diceArray=" + Arrays.toString(diceArray) + '\n' +
                ", score=" + score +
                '}';
    }
}

class Dice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    public Dice() {
        this.diceNumber = (int) (Math.random() * (MAX - MIN + 1)) + MIN; // 주사위 숫자
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "HomeWork.Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}

class Score {
    final private int WIN_DECISION1 = 3;
    final private int WIN_DECISION2 = 4;
    final private int totalScore;

    public Score(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "HomeWork.Score{" +
                "totalScore=" + totalScore +
                '}';
    }

    public Boolean checkWin () {
        if ((totalScore % WIN_DECISION1 == 0) ||
                (totalScore % WIN_DECISION2 == 0)) {

            return true;
        }

        return false;
    }
}

public class asdfasdf {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game);
        System.out.println(game.checkWin() ? "승리!" : "패배!");
    }
}