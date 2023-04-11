package problems.prob12;
/*
1.  랜덤으로 반 학생들 20명의 점수를 생성합니다.
2.  학생들의 평균을 계산하는 프로그램을 작성합니다.
    위의 2번 문제에서 만든 학생들의 점수를 정렬하여 순위를 출력해 봅시다.

 */

import customLibrary.customRandom.CustomRandom;

import java.util.*;


class Score {
    final private int MAX_TEST_SCORE = 100;
    final private int MIN_TEST_SCORE = 10;
    private int personalScore;
    public Score () {

        this.personalScore = CustomRandom.generateNumber(MIN_TEST_SCORE, MAX_TEST_SCORE);
    }
    public int getPersonalScore() {

        return personalScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "personalScore=" + personalScore +
                '}';
    }
}
class Student {
    List<Score> studentList = new ArrayList<>();
    final private int STUDENT_NUMBER = 20;

    public Student() {
        Score score = new Score();
        for (int i = 0; i < STUDENT_NUMBER; i++) {
            studentList.add(new Score());
        }
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentList=" + studentList +
                '}';
    }
//
//    @Override
//    public int compareTo(Student student) {
//        final int otherStudentScore = 0; //진행불가
//        return 0;
//    }

    public void Sort() {
        studentList.sort(new Comparator<Score>() {
            @Override
            public int compare(Score s1, Score s2) {
                return s2.getPersonalScore() - s1.getPersonalScore();
            }
        });

    }
}
/*
@Override
    public int compareTo(RefactorDiceGamePlayer otherPlayer) {
        final int otherPlayerTotalScore = otherPlayer.getGameScore().getTotalScore();
        final int currentPlayerTotalScore = this.getGameScore().getTotalScore();

        if (otherPlayerTotalScore < currentPlayerTotalScore) {
            return 1;
        } else if (otherPlayerTotalScore > currentPlayerTotalScore) {
            return -1;
        }

        return 0;
 */


class AverageStudentScore {
    private int totalAverageStudentScore;

    public AverageStudentScore () {

        Student student = new Student();
        int totalStudentScore = 0;
        for (int i = 0; i <= student.studentList.size(); i++) {
            totalStudentScore += student.studentList.get(i).getPersonalScore();
        }
        this.totalAverageStudentScore = totalStudentScore/student.studentList.size();
    }

    public int getTotalAverageStudentScore() {
        return totalAverageStudentScore;
    }

    @Override
    public String toString() {
        return "AverageStudentScore{" +
                "totalAverageStudentScore=" + totalAverageStudentScore +
                '}';
    }
}



public class Problem12 {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student);
        student.Sort();
        System.out.println(student);
    }
}
