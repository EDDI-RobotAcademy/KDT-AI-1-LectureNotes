package review1.sangwon;

import java.util.List;

public class Versus {
    public void pandan(List<Integer> totalScore, String playerName1, String playerName2) {

        if (totalScore.get(0) > totalScore.get(1)) {
            System.out.println(playerName1 + " 이(가) 승리했습니다. ");
        }
        if (totalScore.get(1) > totalScore.get(0)) {
            System.out.println(playerName2 + " 이(가) 승리했습니다.");
        }
        if (totalScore.get(0) == totalScore.get(1)) {
            if (totalScore.get(0) == -1) {
                System.out.println("공동 패배 입니다.");
            } else {
                System.out.println("무승부 입니다.");
            }

        }

    }
}
