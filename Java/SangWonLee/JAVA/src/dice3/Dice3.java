package dice3;

import java.util.*;

public class Dice3 {


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

        String playerName1 = "aa ";
        String playerName2 = " aa";

        int Score1 = 0;
        int Score2 = 0;

        int START = 0;

        List<Integer> dice1 = new ArrayList<>();
        List<Integer> dice2 = new ArrayList<>();

//        ArrayList player1 = new ArrayList<>();
//        dice1.add(5);
//        dice1.add(7);
//        dice1.add(8);
//
//        player1.add(playerName1);
//        player1.add(dice1);
//        player1.get(1);
//        for (Object ff: player1)
//        {
//
//
//        }


//        System.out.println(player1.get(1));

        ArrayList player2 = new ArrayList<>();


        int playerDog = 2; // 플레이어 갯수
        int diceDog = 3; // 주사위 갯수
        int MAX_Dice = 6;
        int MIN_Dice = 1;
        int diceJJak = 2; // 짝수 일 때 쓰일 숫자.

        int stealScore = 3; // 뺏을 점수
        int getScore = 2; // 얻을 점수
        int defeatScore; // 질 점수

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

//        Map<String ,List[]> playerDice = new HashMap<>();

        System.out.print("플레이어 1 이름을 입력해주세요 : ");
        playerName1 = sc1.nextLine();
        System.out.print("플레이어 2 이름을 입력해주세요 : ");
        playerName2 = sc2.nextLine();

//        for (int j = START; j < playerDog; j++) {
            for (int i = START; i < diceDog; i++) {
                dice1.add((int) (Math.random() * (MAX_Dice - MIN_Dice + 1) + MIN_Dice));
                if (dice1.get(0) % diceJJak == 0) {
                    dice1.add(0);
                    dice1.add(0);
                    break;
                }
//            }


        }
        System.out.println(dice1);

        for (int i = START; i < diceDog; i++) {
            dice2.add((int) (Math.random() * (MAX_Dice - MIN_Dice + 1) + MIN_Dice));
            if (dice2.get(0) % diceJJak == 0) {
                dice2.add(0);
                dice2.add(0);
                break;
            }
        }
        System.out.println(dice2);

        for (int oneDice : dice1) {
            Score1 += oneDice;
        }

        for (int twoDice : dice2) {
            Score2 += twoDice;
        }
        System.out.println("시작 스코어 → " + Score1 + "  :  " + Score2);


        switch (dice1.get(2)) {
            case 1:
                System.out.println(playerName1 + " 훔치기");
                Score1 = Score1 + stealScore;
                Score2 = Score2 - stealScore;
                System.out.println("현재 → " + Score1 + "  :  " + Score2);
                break;
            case 3:
                System.out.println(playerName1 + " 점수 획득");
                Score1 = Score1 + getScore;
                System.out.println("현재 → " + Score1 + "  :  " + Score2);
                break;
            case 4:
                System.out.println(playerName1 + " 무조건 패배");
                Score1 = -1;
                System.out.println("현재 → " + Score1 + "  :  " + Score2);
                break;
            default:

        }
        switch (dice2.get(2)) {
            case 1:
                System.out.println(playerName2 + " 훔치기");
                Score2 = Score2 + stealScore;
                Score1 = Score1 - stealScore;
                System.out.println("현재 → " + Score1 + "  :  " + Score2);
                break;
            case 3:
                System.out.println(playerName2 + " 점수 획득");
                Score2 = Score2 + getScore;
                System.out.println("현재 → " + Score1 + "  :  " + Score2);
                break;
            case 4:
                System.out.println(playerName2 + " 무조건 패배");
                Score2 = -1;
                System.out.println("현재 → " + Score1 + "  :  " + Score2);
                break;
        }

        System.out.println("결과 → " + Score1 + "  :  " + Score2);

        if (Score1 > Score2) {
            System.out.println(playerName1 + " 이(가) 승리했습니다. ");
        }
        if (Score2 > Score1) {
            System.out.println(playerName2 + " 이(가) 승리했습니다.");
        }
        if (Score1 == Score2) {
            if (Score1 == -1) {
                System.out.println("공동 패배 입니다.");
            } else {
                System.out.println("무승부 입니다.");
            }

        }


    }


}

