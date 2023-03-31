package homework.diceThirdGame;

import java.util.Arrays;

public class DicePlayer {
    final private int DICE_MAX_NUM = 3;
    final private int[] diceArray;
    final private String name;
    private DiceDice diceArrayObject = new DiceDice(); //주사위 객체 생성

    // --> * 각 플레이어의 세번째 수를 받아오려면 플레이어에게 누적 점수가 있어야 한다고 판단됨
    final private DiceScore diceGameScore = new DiceScore();

    public DicePlayer(String name){
        this.name = name;
        diceArray = new int[DICE_MAX_NUM]; //주사위 3개를 넣을 배열 생성
    }

    public int rollDice(int i){
        return diceArray[i] = diceArrayObject.randomDice();
    }

    public int addScore(int diceArray){
        //(2) 받아온 값을 점수 객체에게 주고 누적 값을 가져오자 !
        return diceGameScore.totalScore(diceArray);
    }

    public String getName() {
        return name;
    }

    public DiceScore getDiceGameScore() {
        return diceGameScore;
    }

    @Override
    public String toString() {
        return "DicePlayer{" +
                "diceArray=" + Arrays.toString(diceArray) +
                ", name='" + name + '\'' +
                ", diceGameScore=" + diceGameScore +
                '}';
    }
}
