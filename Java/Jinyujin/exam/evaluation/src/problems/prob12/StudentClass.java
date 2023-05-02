package problems.prob12;
// 학생 점수 20개 랜덤 생성 - 커스텀랜덤
// 평균 계산 프로그램 작성
// 만든 20개 점수로 순위 출력

import customLibrary.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class StudentClass {

    final private int MIN_SCORE = 0;
    final private int MAX_SCORE = 100;
    final private List<Integer> scoreList = new ArrayList<>();
    private int scoreSum = 0;
    final private float STUDENT_COUNT = 20;

    // 학생 점수 20개 랜덤 생성 - 완료
    public void findStudentScore() {

        for (int i = 0; i < STUDENT_COUNT; i++) {
            int studentScore = CustomRandom.generateNumber(MIN_SCORE, MAX_SCORE);
            scoreList.add(studentScore);
            scoreSum += scoreList.get(i);
        }

        System.out.println(scoreList);
        System.out.println(scoreSum);
    }

    // 학생들 평균 점수 계산
    // 총점/20
    public void calculateAverageScore() {

        float averageScore = scoreSum/STUDENT_COUNT;

        System.out.println(averageScore);
    }

    public void showRank() {
        for (int i = 0; i < STUDENT_COUNT; i++) {
            int rank = 1;
            for (int j = 0; j < STUDENT_COUNT; j++) {
                if (scoreList.get(i) < scoreList.get(j)) {
                    rank++;
                }
            }
            System.out.println("점수: " + scoreList.get(i) + " 등수: " + rank);
        }
    }
}
