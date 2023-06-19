package review1.sangwon;

import java.util.ArrayList;
import java.util.List;

public class ReviewSpecialDice3 {
    int stealScore = 3; // 뺏을 점수
    int getScore = 2; // 얻을 점수
    int defeatScore; // 질 점수

    List<Integer> totalScore = new ArrayList<>();

    public List<Integer> goodDice(
            List<Integer> doDice1, List<Integer> doDice2,
            String playerName1, String playerName2,
            int score1, int score2) {

        // 동작하도록 만든게 대단한 것 같은 부분입니다.
        // diceList에서 3번째 요소인 특수 주사위를 뽑습니다.
        // 근데 doDice1 이고 2는 또 뭐지 ? 하는 혼선이 발생합니다.
        // diceList1.get(SPECIAL_DICE); 형태였다면
        // 아 주사위 리스트에서 특수 주사위 값 얻는구나라는 것을 바로 알 수 있습니다.
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

        // 그 다음에 두 번째 주사위 리스트에 대해서도 동일한 처리를 하고 있습니다.
        // 이 부분은 하나의 함수로 정리를 했으면 더 좋았을 것입니다.
        // 일단 goodDice는 주사위 개수가 1개만 더 늘어나도 지옥의 코드가 됩니다.
        // 주사위 개수를 조금 더 늘리고 옵션을 변경하고 추가하게 되면
        // 더더욱 끔찍한 상황이 발생하게 될 것입니다.
        // 사용자들이 게임이 심심하니까 이런 부가 기능 넣어주세요.
        // 라고 이야기 하는 순간 말도 안되는 노가다를 해야 합니다.
        // 왜냐하면 전부 통으로 때려박았기 때문입니다.
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
        totalScore.add(score1);
        totalScore.add(score2);

        // goodDice의 목적은 결국 getTotalScore()
        // applySpecialDiceOption()
        // 두 가지 행위가 하나의 덩어리로 뭉쳐져 있었습니다.
        return totalScore;
    }
}
