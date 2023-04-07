package dice3;

import java.util.ArrayList;
import java.util.List;

public class SpecialDice {

    List<Score> totalScore;

    public SpecialDice(List<Score> scoreDiceList) {
        this.totalScore = scoreDiceList;
    }


    public void stealScore(int specialPersonIndex) {
//        for (int i = 0; i<totalScore.size(); i++ ) {
//            System.out.println(totalScore.get(i).getScore());
//        }
        //    int stealScore = 3; // 뺏을 점수

        System.out.println();

    }

    public List<Score> eatScore(int specialPersonIndex) {

        int getScore = 2; // 얻을 점수


        int eatTotalScore = totalScore.get(specialPersonIndex).getScore() + getScore;
        totalScore.get(specialPersonIndex).setScore(eatTotalScore);

        System.out.println();






        for (int i = 0; i<totalScore.size(); i++ ) {
            System.out.print(totalScore.get(i).getScore() + " ");
        }

        return totalScore;

    }

    public void defeatScore(int specialPersonIndex) {
        //    int defeatScore; // 질 점수
    }


    }
