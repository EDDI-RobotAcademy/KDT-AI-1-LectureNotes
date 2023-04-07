package homework.second;

import java.util.Arrays;
class Game {

    final private int MAX_DICE = 4;
    final private Dice[] diceArray;
    final private Score score;

    public Game() {
        // 이 부분은 Dice 배열 몇 개를 사용하겠습니다.
        this.diceArray = new Dice[MAX_DICE];
        int diceNumberSum = 0;

        for (int i = 0; i < diceArray.length; i++) {
            // 각 배열의 요소를 할당하겠습니다.
            diceArray[i] = new Dice();
            diceNumberSum += diceArray[i].getDiceNumber();
        }

        this.score = new Score(diceNumberSum);
    }

    public Boolean checkWin () {
        return score.checkWin();
    }

    // 정보 출력
    // toString이 있으면
    // System.out.println() 할 때 toString 내용이 출력됨
    @Override
    public String toString() {
        return "Game{" +
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
        this.diceNumber = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "Dice{" +
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
        return "Score{" +
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

public class SecondHomeworkFirstGuide {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game);
        System.out.println(game.checkWin() ? "승리!" : "패배!");
    }
}
