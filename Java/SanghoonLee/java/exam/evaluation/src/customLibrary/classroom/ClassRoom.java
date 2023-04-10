package customLibrary.classroom;

import customLibrary.utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassRoom {
    final private int maxStudentNumber;
    final private List<Integer> studentScoreList;
    private float mean;

    public ClassRoom(int maxStudentNumber) {
        this.maxStudentNumber = maxStudentNumber;

        studentScoreList = new ArrayList<>();
    }

    public void evalauteStudent() {
        int tmpSum = 0;
        for (int i = 0; i < maxStudentNumber; i++) {
            final int randomScore = CustomRandom.generateNumber(100);
            tmpSum += randomScore;
            studentScoreList.add(randomScore);
        }

        mean = tmpSum / ((float)maxStudentNumber);
    }

    public void printRank() {
        Collections.sort(studentScoreList, Collections.reverseOrder());
        System.out.println(studentScoreList);

        int rank = 1;
        int backupScore = 0;
        int sameScoreCount = 0;
        Boolean isSameScore = false;

        for (int i = 0; i < maxStudentNumber; i++) {
            isSameScore = false;

            final int currentScore = studentScoreList.get(i);
            if (backupScore == currentScore) {
                sameScoreCount++;
                isSameScore = true;
            } else { sameScoreCount = 0; }

            System.out.println(
                    "순위: " + ((isSameScore) ? (rank++ - sameScoreCount) : (rank++))+
                    ", 점수: " + currentScore);

            backupScore = currentScore;
        }
    }

    public float getMean() {
        return mean;
    }
}
