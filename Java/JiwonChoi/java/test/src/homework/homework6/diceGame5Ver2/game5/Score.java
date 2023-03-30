package homework.homework6.diceGame5Ver2.game5;

import java.util.ArrayList;

import static homework.homework6.diceGame5Ver2.game5.Dice.diceCount;
import static homework.homework6.diceGame5Ver2.game5.Dice.getDiceSum;

public class Score {

//    static void SumBousScore(Player player){
static void SumBousScore(ArrayList<Player> playerList){

        int specialDice1 = 1; //변수로 넣으면 반복문 동작 안됨;;;
        int specialDice3 = 3;
        int specialDice4 = 4;

        for (int i = 0; i<diceCount; i++) {
            //세번째다이스 넘버가
            switch (playerList.get(i).diceArray[2].getDiceNumber()) {
                //1이면
                case 1:
                    playerList.get(i).setAfterScore(getDiceSum() + 3);

                    break;

                //3이면
                case 3:
                    playerList.get(i).setAfterScore(getDiceSum() + 2);
                    break;

                //4면
                case 4:
                    playerList.get(i).setAfterScore(0);
                    break;
                //아무것도 아니면
                default:
                    playerList.get(i).setAfterScore(getDiceSum());
                    break;
            }
        }



    }

}
