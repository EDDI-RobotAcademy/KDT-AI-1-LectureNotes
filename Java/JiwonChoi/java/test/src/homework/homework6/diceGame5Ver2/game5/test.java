package homework.homework6.diceGame5Ver2.game5;

import java.util.ArrayList;

import static homework.homework6.diceGame5Ver2.game5.Dice.diceSum;
import static homework.homework6.diceGame5Ver2.game5.Dice.rollDice;
import static homework.homework6.diceGame5Ver2.game5.Player.playerAdd;
//import static homework.homework6.diceGame5Ver2.game5.Player.playerList;
import static homework.homework6.diceGame5Ver2.game5.Score.SumBousScore;

public class test {
    public static void main(String[] args) {
        ArrayList<Player> playerList = new ArrayList<>(); //모든 플레이어의 모음

        playerAdd("이00", playerList);//김00 이름의 플레이어 추가
        playerAdd("김00", playerList);
        System.out.println(playerList);



//        rollDice(playerList.get(0));    //주사위 굴리기
//        diceSum(playerList.get(0));     //주사위 합하기
//        SumBousScore(playerList);    //보너스 점수 합하기
//
//        System.out.println(playerList.get(0));      //플레이어[0]의 정보 출력 (이름, 주사위배열, 주사위합, 총점수)

//
//        playerAdd("이00");
//        rollDice(playerList.get(1));
//        System.out.println(playerList.get(1));
//        System.out.println(diceSum(playerList.get(1)));
//
//        playerAdd("박00");
//        rollDice(playerList.get(2));
//        diceSum(playerList.get(2));

//        System.out.println(playerList.get(0));



    }
}
