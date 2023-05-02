package examPractice.classRoom;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 반 학생 수 20명 점수 생성
// 평균 계산 프로그램 작성
public class ClassRoom {
    final private int maxStudentNumber;
    private float mean;
    List<Integer> studentScoreList = new ArrayList<>();

    public ClassRoom(int maxStudentNumber) {
        this.maxStudentNumber = maxStudentNumber;
    }

    public void evaluateStudent() {
        int scoreSum = 0;

        // 랜덤 점수 20개 생성
        for (int i = 0; i < maxStudentNumber; i++) {
            final int randomScore = CustomRandom.generateNumber(100);
            // 점수 20개 합산
            scoreSum += randomScore;
            studentScoreList.add(randomScore);
        }
        mean = scoreSum/(float) maxStudentNumber;
        System.out.println("평균 점수: " + mean);
    }

    // 순위 출력
    public void printRank() {
        //점수 정렬
        Collections.sort(studentScoreList, Collections.reverseOrder());
        // Collections.sort(list); -> 오름차순 정렬
        // Collections.sort(list, Collections.reverseOrder()); -> 내림차순 정렬
        System.out.println(studentScoreList);

        // 중복을 방지하기 위함
        int rank = 1;
        boolean isSameScore = false;
        int backupScore = 0;
        int sameScoreCount = 0;

        // 순위 출력
        for (int i = 0; i < maxStudentNumber; i++) {
            isSameScore = false;

            final int currentScore = studentScoreList.get(i);
            if (currentScore == backupScore) {
                sameScoreCount++;
                isSameScore = true;
            } else {
                sameScoreCount = 0;
            }
            System.out.println(isSameScore ?
                    rank++ - sameScoreCount : rank++ + currentScore);
        }
    }
}
