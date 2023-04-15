package Review.diceGame.diceGame2;
/*
[주사위문제2]
주사위 4개를 만들어서 돌립시다.
4개의 주사위를 굴려서 합이 3 혹은 4의 배수가 된다면 승리
그 외의 케이스는 패배 처리하도록 만들어 봅시다!
이번에는 Class 개념을 도입해서 만들어봅시다.
*/

import java.util.ArrayList;

class Game{
    final int DICE_COUNT = 4;
    ArrayList<Dice> dicesList;
    Score score;

    public Game() {
    }

    public void PlayGame() {

        this.dicesList = new ArrayList<>();
        this.score = new Score();

        for(int i = 0; i < DICE_COUNT; i++){
            dicesList.add(new Dice());
        }


        int tmpSum = 0;
        for(int i = 0; i < dicesList.size(); i++){
            int diceNum = dicesList.get(i).getDiceNum();
            tmpSum += diceNum;
        }

        score.setTotalScore(tmpSum);
    }


    @Override
    public String toString() {
        return "Game{" +
                "DICE_COUNT=" + DICE_COUNT +
                ", dicesList=" + dicesList +
                ", score=" + score +
                '}';
    }
}
class Dice{
    final int DICE_MIN = 1;
    final int DICE_MAX = 6;
    int diceNum;

    public Dice() {
        this.diceNum = (int)(Math.random()*(DICE_MAX-DICE_MIN+1)) + DICE_MIN;
    }

    public int getDiceNum() {
        return diceNum;
    }



    @Override
    public String toString() {
        return "Dice{" +
                "diceNum=" + diceNum +
                '}';
    }
}
class Score{
    int totalScore = 0;

    public Score() {
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void winnerCheck(){
        if( totalScore % 3 == 0 ) {
            System.out.println("3의 배수입니다. 승리하셨습니다.");
        }
        else if( totalScore % 4 == 0 ) {
            System.out.println("4의 배수입니다. 승리하셨습니다.");

        } else {System.out.println("패배하셨습니다.");}
    }

    @Override
    public String toString() {
        return "Score{" +
                "totalScore=" + totalScore +
                '}';
    }
}

public class DiceGame2 {
    public static void main(String[] args) {

        Game game1 = new Game();
        System.out.println(game1);

        game1.PlayGame();
        System.out.println(game1);

        game1.score.winnerCheck();

    }
}