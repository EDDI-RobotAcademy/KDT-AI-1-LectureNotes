package problems.prob12;

import customLibrary.CustomRandom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenerateScore {
    private final int STUDENT_NUM = 20;
    private int totalScore;
    private double averageScore;
    private List<Integer> studentScoreList = new ArrayList<>();
    

    public GenerateScore() {
        for(int i = 0; i < STUDENT_NUM; i++) {
            studentScoreList.add((int)CustomRandom.generateNumber(0, 100));
        }
    }

    public void getAverageScore() {
        for (int i:studentScoreList) {
            totalScore += i;
        }
        averageScore = (double)totalScore/STUDENT_NUM;
        System.out.println("학생 " + STUDENT_NUM + "명의 평균점수는 " + averageScore + "점");
    }

    public void getScoreRank() {
        Collections.sort(studentScoreList, Collections.reverseOrder());
        for (int i = 1; i <= studentScoreList.size(); i++) {
            System.out.println(i + "등은 " + studentScoreList.get(i-1)+"점");
        }

    }
}
