package problems.prob12;

import java.util.*;

// 복합문제 12 ~ 13
// 학생들의 점수를 정렬하여 순위를 출력하는거 빼고 풀었습니다.
// SequenceProblem 이 14번 문제 입니다.

public class Problem12 {
    public static void main(String[] args) {

        List<Student> studentScoreList = new ArrayList<>();
        int studentNumber = 20;

        for (int i = 0; i < studentNumber; i++) {
            Student student = new Student();
            studentScoreList.add(student);

        }
        for (int i = 0; i < studentScoreList.size(); i++) {
            System.out.print(studentScoreList.get(i).getScore() + " ");

        }

        System.out.println();
        System.out.println(studentScoreList.get(0));
        Collections.sort(studentScoreList, Collections.reverseOrder());

        Student abcd = studentScoreList.get(0);

    }
}
