package problems.prob12;

import customLibrary.prob12.Student;


import java.util.Collections;

public class Problem12 {
    public static void main(String[] args) {
        //12번 13번 문제
        Student randomScoreStudent = new Student();

        //랜덤으로 20명 반 학생들 점수 생성과
        randomScoreStudent.studentRandomScore();

        System.out.println();//개행

        // 랜덤으로 점수를 만든 20명 학생들의 평균
        randomScoreStudent.studentAverage();

        System.out.println();//개행

        //위에서 만든 학생을의 점수를 정렬하여 순위 출력
        randomScoreStudent.Rank();


    }
}
