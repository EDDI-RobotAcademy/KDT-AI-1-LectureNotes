package test.componont;

import javax.swing.*;

public class GameScore {
    private int totalScore;

    public GameScore(int totalScore) {  // 생성자를 만들어줌
        this.totalScore = totalScore;
    }

    public void takeScore(GameScore otherScore, int stealScore) {
        this.totalScore -= stealScore;       // 상대방이 세 번째 주사위가 1인경우
        otherScore.totalScore += stealScore; // 3점을 얻음
    }

    public void addScore(int buffScore) {    // 세 번째 숫자가 3인경우
        this.totalScore += buffScore;        // 2점을 얻음
    }

    public void loseAll(int deathScore) {    // 세 번째 숫자가 4인경우
        this.totalScore = deathScore;        // 무조건 패배
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }
    public int getTotalScore() {            // 이부분에 getter를 왜써야하는지 모르겠음.
        return totalScore;
    }
}
