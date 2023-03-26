package homework.homework1;

import homework.homework1.refacktor.diceGame;
import homework.homework1.refacktor.rollDice;
class Dice {
    public Dice(int COUNT_DICE, int MAX_DICE, int startScore) {
        this.COUNT_DICE = COUNT_DICE;
        this.MAX_DICE = MAX_DICE;
        this.startScore = startScore;
    }

    //주사위 개수
    private int COUNT_DICE;
    public int getCOUNT_DICE() {
        return COUNT_DICE;
    }
    public void setCOUNT_DICE(int COUNT_DICE) {
        this.COUNT_DICE = COUNT_DICE;
    }

    //주사위 최대값
    private int MAX_DICE;
    public int getMAX_DICE() {
        return MAX_DICE;
    }
    public void setMAX_DICE (int MAX_DICE) {
        this.MAX_DICE = MAX_DICE;
    }

    //주사위의 총합
    private int startScore;
    public int getstartScore() {
        return startScore;
    }
    public void setstartScore(int startScore) {
        this.startScore = startScore;
    }
}


public class diceClass {
    public static void main(String[] args) {
        final int countDice = 4; //주사위 개수
        final int maxDice = 6; //주사위 최고 숫자
        final int minDice = 1; //주사위 최소숫자
        int startScore = 0; //시작 점수

        //주사위 설정
        Dice game1 = new Dice(countDice, maxDice, startScore);
        System.out.println(
                "주사위 개수 :" + game1.getCOUNT_DICE() + "," +
                "주사위 최대값 :" + game1.getMAX_DICE() + ",");
        System.out.println();

        //주사위 굴리기
        rollDice.rollDice(countDice, maxDice, minDice, startScore);
        System.out.println(startScore);

        // 승리판정
        final int winNumber1 = 3;
        final int winNumber2 = 4;
        System.out.println(diceGame.diceGame(startScore, winNumber1, winNumber2 ));
    }

}
