package problems.prob12;

import problems.CustomRandom;

import java.util.*;

// 평균 구하는 방법 총점 나누기 학생수
public class StudentClass {
    private int Student = 20;
    private int MAX_SCORE = 100;
    private int MIN_SCORE = 0;
    List<Integer> StudentScoreList = new ArrayList<>();
    int AverageScore = 0;
    int ScoreSum = 0;

    public StudentClass() {
        for (int i = 0; i < Student; i++) {
            StudentScoreList.add(CustomRandom.generateNumber(MIN_SCORE,MAX_SCORE));
            ScoreSum += StudentScoreList.get(i);
            AverageScore = ScoreSum / Student;

        }

        StudentScoreList.sort(Comparator.reverseOrder());
        System.out.println("학생들의 점수" + StudentScoreList);
        System.out.println("학생들의 총점" + ScoreSum);
        System.out.println("평균점수" + AverageScore);
    }

}
