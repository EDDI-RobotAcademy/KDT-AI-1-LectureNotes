package problems.prob12;

import customLibrary.CustomRandom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentScore {

    final private int STUDENT_NUMBER = 20;
    final private int MIN_SCORE = 0;
    final private int MAX_SCORE = 100;
    int sum = 0;
    double average = 0;

    List<Student12> studentList = new ArrayList<>();

    public StudentScore(){
        for(int i=0; i<STUDENT_NUMBER; i++){
            int randomScore = CustomRandom.generateNumber(MIN_SCORE,MAX_SCORE);
            sum += randomScore;
            studentList.add(new Student12("학생"+(i+1),randomScore));
        }
    }

    public void averageStudentScore(){
        average = (double)sum / STUDENT_NUMBER;
        System.out.println("평균 : " + average);
    }

    public void rankStudent(){

        studentList.sort(new Comparator<Student12>() {
            @Override
            public int compare(Student12 o1, Student12 o2) {
                return o2.getScore() - o1.getScore();
            }
        });

        int rank = 1;
        int backupScore = 0;
        int sameScoreCount = 0;
        boolean isSameScore;

        for (Student12 student : studentList) {
            isSameScore = false;

            final int currentScore = student.getScore();
            if (backupScore == currentScore) {
                sameScoreCount++;
                isSameScore = true;
            } else {
                sameScoreCount = 0;
            }

            System.out.println(
                    "순위: " + ((isSameScore) ? (rank++ - sameScoreCount) : (rank++)) +
                            ", 이름: " + student.getName() +
                            ", 점수: " + currentScore);

            backupScore = student.getScore();
        }
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "studentList=" + studentList +
                ", sum=" + sum +
                '}';
    }
}
