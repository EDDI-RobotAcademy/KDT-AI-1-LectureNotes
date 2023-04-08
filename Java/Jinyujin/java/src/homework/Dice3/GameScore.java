package homework.Dice3;

// 게임스코어 클래스
public class GameScore {
    // 총점 변수 생성
    int totalScore;

    public int getTotalScore() {
        return totalScore;
    }

    public GameScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void takeScore(GameScore otherScore, int stealScore) {

        this.totalScore -= stealScore;
        otherScore.totalScore +=stealScore;
    }

    public void addScore(int buffScore) {
        this.totalScore += buffScore;
    }

    public void loseAll(int deathScore) {
        this.totalScore = deathScore;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }
}
