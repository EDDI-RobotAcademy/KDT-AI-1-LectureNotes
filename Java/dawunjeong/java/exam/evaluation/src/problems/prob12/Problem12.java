package problems.prob12;

import customLibrary.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 문제 12번, 13번
class StudentScore{
    private int studentScore;
    final private List<Integer> studentScoreList = new ArrayList<>();
    final private int MIN_SCORE = 80;
    final private int MAX_SCORE = 100;

    public StudentScore() {
        this.studentScore = studentScore;
    }

    public void randomStudentScore(int studentNum){
        for(int i = 0; i < studentNum; i++){
            studentScoreList.add(RandomGenerator.generateNumber(MIN_SCORE, MAX_SCORE));
        }
    }

    public int calculateAverageScore(){
        int sum = 0;
        int scoreAvg;
        final int studentNum = studentScoreList.size();
        for(int i = 0; i < studentNum; i++){
            sum += studentScoreList.get(i);
        }
        scoreAvg = sum / studentNum;
        return scoreAvg;
    }
    public void printStudentScoreRank(){
        int scoreRank[] = new int[studentScoreList.size()];
        Collections.sort(studentScoreList, Collections.reverseOrder());
        for(int i = 0; i < studentScoreList.size(); i++){
            scoreRank[i] = studentScoreList.get(i);
            System.out.println((i + 1) + "등의 점수: " + scoreRank[i] + "점");
        }
    }
    @Override
    public String toString() {
        return "StudentScore{" +
                "studentScoreList=" + studentScoreList +
                '}';
    }
}
public class Problem12 {
    public static void main(String[] args) {
        StudentScore studentScore = new StudentScore();
        studentScore.randomStudentScore(3);
        System.out.println(studentScore);
        System.out.println("평균 점수: " + studentScore.calculateAverageScore() + "점");
        studentScore.printStudentScoreRank();

    }
}
