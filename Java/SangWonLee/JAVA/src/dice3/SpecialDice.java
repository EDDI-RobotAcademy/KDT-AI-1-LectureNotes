package dice3;

import java.util.List;

public class SpecialDice {
    int stealScore = 3; // 뺏을 점수

    int getScore = 2; // 얻을 점수
    int defeatScore; // 질 점수


    public Integer goodDice(List<Integer> doDice1,List<Integer> doDice2, String playerName1,String playerName2, int score1, int score2) {
        switch (doDice1.get(2)) {
            case 1:
                System.out.println(playerName1 + " 훔치기");
                score1 = score1 + stealScore;
                score2 = score2 - stealScore;
                System.out.println("현재 → " + score1 + "  :  " + score2);
                break;
            case 3:
                System.out.println(playerName1 + " 점수 획득");
                score1 = score1 + getScore;
                System.out.println("현재 → " + score1 + "  :  " + score2);
                break;
            case 4:
                System.out.println(playerName1 + " 무조건 패배");
                score1 = -1;
                System.out.println("현재 → " + score1 + "  :  " + score2);
                break;
            default:
        }

        switch (doDice2.get(2)) {
            case 1:
                System.out.println(playerName2 + " 훔치기");
                score2 = score2 + stealScore;
                score1 = score1 - stealScore;
                System.out.println("현재 → " + score1 + "  :  " + score2);
                break;
            case 3:
                System.out.println(playerName2 + " 점수 획득");
                score2 = score2 + getScore;
                System.out.println("현재 → " + score1 + "  :  " + score2);
                break;
            case 4:
                System.out.println(playerName2 + " 무조건 패배");
                score2 = -1;
                System.out.println("현재 → " + score1 + "  :  " + score2);
                break;
        }
        return score1 + score2;
    }
}
