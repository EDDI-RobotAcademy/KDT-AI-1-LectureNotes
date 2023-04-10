package problems.prob12;

import customLibrary.utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ScoreManager {
    List<Student> studentScoreList = new ArrayList<>();

    public void addStudentScore(Student student) {
        studentScoreList.add(student);
    }

    public List<Student> getStudentScoreList() {
        return studentScoreList;
    }

    public int scoreAverage() {
        int tmpSum = 0;
        int tmpAverage;

        for (int i = 0; i < studentScoreList.size(); i++) {
            tmpSum += studentScoreList.get(i).getScore();
        }
        tmpAverage = tmpSum / studentScoreList.size();
        return tmpAverage;
    }
}

class Student implements Comparable <Student>{
    String name;
    int Score = CustomRandom.generateNumber(0, 100);

    public int getScore() {
        return Score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", Score=" + Score +
                '}' +'\n';
    }

    @Override
    public int compareTo(Student student) {
        return this.Score -student.Score;
    }
}


public class Problem12 {
    public static void main(String[] args) { //12~13 완료했습니다.
        ScoreManager scoreManager = new ScoreManager();
        List<Student> studentList = scoreManager.getStudentScoreList();
        for (int i = 0; i < 20; i++) {
            scoreManager.addStudentScore(new Student());
        }

        System.out.println(studentList);
        System.out.println("---------------점수순으로 정렬-----------");
        Collections.sort(studentList,Collections.reverseOrder());
        System.out.println(studentList);
        System.out.println(scoreManager.scoreAverage());



    }
}

