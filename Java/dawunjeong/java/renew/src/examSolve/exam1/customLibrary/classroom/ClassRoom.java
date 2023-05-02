package examSolve.exam1.customLibrary.classroom;

import examSolve.exam1.customLibrary.utility.randomNumber.CustomRandomNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassRoom {
    final int STUDENT_NUM;
    final List<Integer> studentScoreList;
    float avgScore;

    // 학생수를 입력받아 점수리스트를 생성
    public ClassRoom(int STUDENT_NUM) {
        this.STUDENT_NUM = STUDENT_NUM;
        studentScoreList = new ArrayList<>();
    }

    // 학생수만큼 루프를 돌며 랜덤한 점수를 점수 리스트에 대입
    // 루프를 돌며 점수의 총합을 업데이트
    // 총합을 학생수로 나누어 평균내기
    public void calculateAvgScore(){
        int tmpSum = 0;
            for(int i = 0; i < STUDENT_NUM; i++){
                final int randomScore = CustomRandomNumber.generateRandomNumber(0,100);
                tmpSum += randomScore;
                studentScoreList.add(randomScore);
            }
            avgScore = tmpSum / ((float) STUDENT_NUM);
    }

    // 점수 리스트를 내림차순으로 정렬하여 랭크 부여
    // 이전 점수랑 비교하여 현재 점수가 같으면 sameScoreCount를 +1하고
    // isSameScore을 true로 바꾼다.
    // 출력할 때 isSameScore가 true이므로 순위는 rank++에서 sameScoreCount만큼 빼서 출력한다.
    // 그리고 이전 점수(backupScore)는 현재 스코어를 대입한다.
    public void printRank(){
        Collections.sort(studentScoreList, Collections.reverseOrder());
        System.out.println(studentScoreList);

        int rank = 1;
        int backupScore = 0;
        int sameScoreCount = 0;
        Boolean isSameScore = false;

        for(int i = 0; i < STUDENT_NUM; i++){
            isSameScore = false;
                final int currentScore = studentScoreList.get(i);
                if(backupScore == currentScore){
                    sameScoreCount++;
                    isSameScore = true;
                } else{
                    sameScoreCount = 0;
                }
            System.out.println("순위: " + ((isSameScore) ? (rank++ - sameScoreCount) : (rank++))
                    + ", 점수: " + currentScore);
                backupScore = currentScore;
        }
    }

    public float getAvgScore() {
        return avgScore;
    }

    public List<Integer> getStudentScoreList() {
        return studentScoreList;
    }
}
