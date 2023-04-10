package problems.prob12;

import customLibrary.utility.CustomRandom;
import customLibrary.utility.classProb12.Student;

public class Problem12 {

    public static void main(String[] args) {
        // 12번
        int sum = 0;
        final int STUDENT_NUMBER = 20;

//        for (int i = 0; i < STUDENT_NUMBER; i++) {
//            Student student = new Student(i + 1, CustomRandom.generateNumber(100));
//            sum += student.getStudentScore();
//            System.out.println(student.getStudentId() + "번 학생의 점수는 " + student.getStudentScore() + "점 입니다.");
//        }
//        System.out.println("평균 점수는 " + sum / STUDENT_NUMBER + "점 입니다.");

        // 13번
//        int[] rank = new int[scoreList.size()];
//        Arrays.fill(rank, 1);
//        for (int i = 0; i < rank.length; i++) {
//            for (int j = 0; j < rank.length; j++) {
//                if (scoreList.get(i) < scoreList.get(j)) {
//                    rank[i]++;
//                }
//            }
//        }
//        for (int i = 0; i < rank.length; i++) {
//            System.out.println((i + 1) + "번 학생의 점수는 "
//                    + scoreList.get(i)+ "점으로 "
//                    + rank[i] + "등 입니다.");
//        }
    }
}

/*
12. 랜덤으로 반 학생들 20명의 점수를 생성합니다.
학생들의 평균을 계산하는 프로그램을 작성합니다.

13. 위의 12번 문제에서 만든 학생들의 점수를 정렬하여 순위를 출력해 봅시다.
*/