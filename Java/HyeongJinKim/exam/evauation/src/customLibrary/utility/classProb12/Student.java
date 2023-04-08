package customLibrary.utility.classProb12;

import customLibrary.utility.CustomRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private int studentId;
    private int studentScore;
    public Student(int studentId, int studentScore) {
        this.studentId = studentId;
        this.studentScore = studentScore;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public static int studentScoreAverage (int studentNumber) {
        int sum = 0;
        for (int i = 0; i < studentNumber; i++) {
            Student student = new Student(i + 1, CustomRandom.generateNumber(100));
            sum += student.getStudentScore();
        }
        return sum / studentNumber;
    }

    public static void rank (int studentNumber) {
        List<Integer> scoreList = new ArrayList<>();
        int[] rank = new int[studentNumber];
        Arrays.fill(rank, 1);
        for (int i = 0; i < rank.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                if (scoreList.get(i) < scoreList.get(j)) {
                    rank[i]++;
                }
            }
        }
        for (int i = 0; i < rank.length; i++) {
            System.out.println((i + 1) + "번 학생의 점수는 "
                    + scoreList.get(i)+ "점으로 "
                    + rank[i] + "등 입니다.");
        }
    }
}