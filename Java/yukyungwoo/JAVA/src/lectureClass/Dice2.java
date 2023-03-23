package lectureClass;

import java.util.Arrays;

class Game {
    private final int GAME_NUMBER =4;
    private final int[] array;
    private final Score score;

    public Game () {
        this.array = new int[GAME_NUMBER];
        int diceNumberSum = 0;

        for (int i = 0 ; i <  array.length; i++) {
            array[i] = new Dice ();
            diceNumberSum += array[i].getDiceNumber();
        }
        this.score = new Score(diceNumberSum);

    }
    public Boolean checkWin () {
        return score.checkWin();
    }

    @Override
    public String toString() {
        return "Game{" +
                "array=" + Arrays.toString(array) +
                ", score=" + score +
                '}';
    }
}

class Dice {
    private final int diceNumber;
    private final int MAX = 6;
    private final int MIN = 1;

    public Dice () {
        this.diceNumber = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
    }
    public int getDiceNumber () {
        return diceNumber;
    }
    // 주사위 굴리기

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }// 주사위 숫자 출력
}

class Score {
    private final int WIN_DECISION1 = 3; //나머지 값을 위한 상수 결정을 위해
    private final int WIN_DECISION2 = 4;
    private final int totalScore;

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



    public class Dice2 {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game);
        System.out.println(game.checkWin() ? "승리!" : "패배!");
    }
}
