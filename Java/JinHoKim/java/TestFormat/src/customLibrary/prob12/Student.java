package customLibrary.prob12;

import customLibrary.utility.CustomRandom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student {
    final int studentNum = 20;
    int randomStudentScore;
    double average;
    List<Integer> studentscoreList = new ArrayList<>();



    public void studentRandomScore() {
        for (int i = 1; i <= studentNum; i++) { // 20명 랜덤 점수 리스트에 넣기
            randomStudentScore = CustomRandom.generateNumber(100);
            studentscoreList.add(randomStudentScore);
            System.out.println(i + " 번 학생의 랜덤 점수: " + randomStudentScore);
        }
    }

    public double studentAverage() {
        double tmpSum = 0;
        for (int i = 0; i < studentscoreList.size(); i++) {
            tmpSum += studentscoreList.get(i);
        }
        average = tmpSum / studentscoreList.size();
        System.out.println("학생 20명 랜덤점수의 평균은: " + average);
        return average;
    }

    public void Rank() {
        studentscoreList.sort(Comparator.reverseOrder());
        System.out.println("학생들의 점수 순위" + studentscoreList);
    }
}
