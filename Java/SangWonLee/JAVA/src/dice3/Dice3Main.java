package dice3;

import java.util.*;

public class Dice3Main {


//        친구와 게임을 할 수 있습니다.
//        1:1 게임이라 가정하겠습니다.
//        주사위를 3개 굴립니다.
//        첫 번째 주사위가 짝수라면
//        두 번째 주사위와 세 번째 주사위를 굴릴 수 있습니다.
//        두 번째 주사위는 특수 기능이 별도로 존재하지 않습니다.
//        세 번째 주사위는 숫자 1인 경우 친구에게 점수를 3점 뺏을 수 있습니다.
//        숫자가 3인 경우엔 자신에게 2점을 가산합니다.
//        숫자가 4인 경우엔 무조건 패배하게 됩니다.
//        친구와 함께 플레이 할 수 있는 주사위 게임을 만들어주세요.

    public static void main(String[] args) {

        int playerDog = 2; // 플레이어 갯수

        Player player = new Player();
//        player.addPlayer();

        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        List<Integer> doDice1 = dice1.rollDice();
        List<Integer> doDice2 = dice2.rollDice();

        System.out.println(doDice1);
        System.out.println(doDice2);

        Score score1 = new Score(doDice1);
        Score score2 = new Score(doDice2);

        System.out.println("시작 스코어 → " + score1.Score + "  :  " + score2.Score);

        SpecialDice special = new SpecialDice();


        special.goodDice(doDice1,doDice2,player.playerName1,player.playerName2,score1.Score,score2.Score);



        System.out.println("결과 → " + score1.Score + "  :  " + score2.Score);

        if (score1.Score > score2.Score) {
            System.out.println(player.playerName1 + " 이(가) 승리했습니다. ");
        }
        if (score2.Score > score1.Score) {
            System.out.println(player.playerName2 + " 이(가) 승리했습니다.");
        }
        if (score1.Score == score2.Score) {
            if (score1.Score == -1) {
                System.out.println("공동 패배 입니다.");
            } else {
                System.out.println("무승부 입니다.");
            }

        }


    }


}

