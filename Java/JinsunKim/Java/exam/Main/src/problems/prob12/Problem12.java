package problems.prob12;


import customLibrary.Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//랜덤으로 반 학생들 20명의 점수를 생성합니다. 학생들의 평균을 계산하는 프로그램을 작성합니다.
//위의 2번 문제에서 만든 학생들의 점수를 정렬하여 순위를 출력해 봅시다.
class Student2 {
    final private int MAX = 20;
    final private int[] studentArray = new int[MAX];

    int score;

    public Student2() {

        for (int i = 1; i <= studentArray.length; i++) {
            score = Random.generateNumber(100);
            System.out.println("학생" + i + "번 점수는 " + score + "점");
            studentArray[i] = score;
        }
    }
}

public class Problem12 {
    public static void main(String[] args) {
        Student2 student = new Student2();
    }
}
