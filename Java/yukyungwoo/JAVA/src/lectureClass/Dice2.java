package lectureClass;

import java.util.Arrays;

class Game {
    private final int Game_Number =4; //상자를 4개 만들기 위해
    private final Count[] countArray; //상자를 만들기 위해
    private final Score score; // 상자에 주사위를 넣기 위해

    public Game () {
        this.countArray = new Count[Game_Number];
        int diceNumberSum = 0;

        for (int i = 0 ; i < countArray.length; i++) {
            countArray[i] = new Dice();
            diceNumberSum += countArray[i].getDiceNumber();
        }
        /*
        상자4개를 만들기 까지 반복
        그리고 상자의 합은 0부터 시작
        상자에는 Dice에서 온 함수를 넣기 위해 new 인스턴스
        diceNumberSum += countArray[i].getDicenumber();
        그런데 이부분의 뜻을 모르겠습니다
         */
        this.score = new Score(diceNumberSum);

    }
    public Boolean checkWin () {
        return score.checkWin();
    }

    @Override
    public String toString() {
        return "Game{" +
                "countArray=" + Arrays.toString(countArray) +
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
    final int totalScore;
    private final int WIN_DECISION1 = 3; //나머지 값을 위한 상수 결정을 위해
    private final int WIN_DECISION2 = 4;
    private final int totalScore; //이거랑 위에랑 왜 private만 차이나고 똑같은거 두개 적는지?

    public Score(int totalScore) {
        this.totalScore = totalScore;
    }           // totalScore 값을 입력하면 totalScore값을 도출하기 위해?
    public Boolean checkWin () {
        if ((totalScore % WIN_DECISION1 == 0) ||
                (totalScore % WIN_DECISION2 == 0)) {

            return true;
        }

        return false; // 참이면 true 출력 거짓이면 false 출력하기 위해






}

    @Override
    public String toString() {
        return "Score{" +
                "totalScore=" + totalScore +
                '}';
    }


    public class Dice2 {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game);
        System.out.println(game.checkWin() ? "승리!" : "패배!");
    }
}
