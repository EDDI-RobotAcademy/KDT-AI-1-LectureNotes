package customLibrary.prob12;

import java.util.ArrayList;

public class Student {
    final private ArrayList<StudentGradeTest> studentScoreList;
    final private int studentAllNumber = 20;

    public Student(){
        studentScoreList = new ArrayList<>();

        // 반 학생들 20명의 점수 생성
        System.out.println("=== 반 학생들 20명의 점수 생성 ===");
        for(int i = 0; i < studentAllNumber; i++){
            studentScoreList.add(new StudentGradeTest());
            System.out.printf(i+1+"번 학생: " + studentScoreList.get(i).getStudentGrade()+"점 \n");
        }
        studentAverage();
    }

    public void studentAverage(){
        // 반 학생들 20명의 평균
        int gradeAverage = 0;

        for(int i = 0; i < studentAllNumber; i++){
            int grade = studentScoreList.get(i).studentGrade;
            gradeAverage += grade;
        }

        gradeAverage /= studentAllNumber;

        System.out.println();
        System.out.println("반 학생들 20명의 평균 점수: "+gradeAverage+"점 ");
    }


    public void gradeSort() {
        // 각 리스트의 점수를 비교해서 대체해주기

    }
}
