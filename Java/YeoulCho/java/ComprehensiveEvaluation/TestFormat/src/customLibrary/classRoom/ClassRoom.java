package customLibrary.classRoom;

import customLibrary.utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassRoom {
    final private int MAX_STUDENT_NUMBER; // Q. 학생숫자는 바뀔 수 있는게 아닐까? 왜 final일까?
    final private List<Integer> studentScoreList; // 위와 동일
    float average;

    public ClassRoom(int MAX_STUDENT_NUMBER) {
        this.MAX_STUDENT_NUMBER = MAX_STUDENT_NUMBER;
        studentScoreList = new ArrayList<>();
    }

    public void evalauteStudent() {
        int tmpSum =0;
        for(int i =0; i<MAX_STUDENT_NUMBER; i++){
            final int randomStudentScore = CustomRandom.generateNumber(0,100);
            studentScoreList.add(randomStudentScore);
            tmpSum += randomStudentScore;
        }
        average = (float) (tmpSum / MAX_STUDENT_NUMBER);

    }

    public float getAverage() {
        return average;
    }

    public void printRank() {
        Collections.sort(studentScoreList,Collections.reverseOrder());
        System.out.println(studentScoreList); //나라면 여기까지만 썼을 듯

        // 선생님은 동점자들의 순위표시하셨음
        int rank = 1;
        int backupScore = 0;
        int sameScoreCount = 0;
        Boolean isSameScore = false;

        for (int i = 0; i < MAX_STUDENT_NUMBER; i++) {
            isSameScore = false;

            final int currentScore = studentScoreList.get(i);
            if (backupScore == currentScore) { //이해가 잘 안감...ㅠㅠ
                sameScoreCount++;
                isSameScore = true;
            } else { sameScoreCount = 0; }

            System.out.println( //동점자가 나왔어? 그럼 순위는 증가하지 말아야지
                    "순위: " + ((isSameScore) ? (rank++ - sameScoreCount) : (rank++))+
                            ", 점수: " + currentScore);

            backupScore = currentScore;
        }


    }
}
