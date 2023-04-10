package problems.prob12;

import customLibrary.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    final private int STUDENT_NUM = 20;
    final List<Student> studentList;
    final private int TEST_SCORE_MIN = 50;
    final private int TEST_SCORE_MAX = 100;


    public StudentManager(){
        studentList = new ArrayList<>();
        for(int i = 0; i < STUDENT_NUM; i ++) {
            int TEST_SCORE =  CustomRandom.generateNumber(TEST_SCORE_MIN, TEST_SCORE_MAX);
            studentList.add(new Student("학생" + (i+1), TEST_SCORE));
        }
    }

    public void getStudentTestScoreAvr() {
        int studentScoreSum = 0;
        for(int i = 0; i < STUDENT_NUM; i++) {
            studentScoreSum += studentList.get(i).getTestScore();
        }
        System.out.println(STUDENT_NUM + "명 학생들 점수의 평균은: " +
                           studentScoreSum/STUDENT_NUM);
    }

    public void getStudentTestScoreRank() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student t1, Student t2) {
                return t2.getTestScore() - t1.getTestScore();
            }
        });
        for(int i = 0; i < STUDENT_NUM; i++) {
            System.out.println((i+1) + "등: " + studentList.get(i));
        }
    }
}
