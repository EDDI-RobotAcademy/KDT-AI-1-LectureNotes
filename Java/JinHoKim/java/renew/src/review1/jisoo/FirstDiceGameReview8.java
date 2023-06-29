package review1.jisoo;

import java.util.ArrayList;
import java.util.List;

public class FirstDiceGameReview8 {

    final static int STEAL_VALUE = 3;

    private static List<Integer> targetingAttack(List<Integer> scoreList) {
        List<Integer> calculatedScore = new ArrayList<>();

        Integer attackerScore = scoreList.get(1);
        Integer targetScore = scoreList.get(0);

        attackerScore += STEAL_VALUE;
        targetScore -= STEAL_VALUE;

        calculatedScore.add(targetScore);
        calculatedScore.add(attackerScore);

        return calculatedScore;
    }
    public static void main(String[] args) {
        List<Integer> scoreList = new ArrayList<>();
        scoreList.add(13);
        scoreList.add(20);
        System.out.println(scoreList);

        scoreList = targetingAttack(scoreList);
        System.out.println(scoreList);
    }
}
