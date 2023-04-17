package DiceGame.Player;
public class GameScore {
    private int totalScore;

    public GameScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void takeScore(GameScore otherScore, int stealScore) {
        // 총 점수에서 스틸(3) 수 만큼 - 하기
        this.totalScore -= stealScore;
        // 또 다른거에 총 점수에서 스틸(3) 수 만큼 + 하기
        otherScore.totalScore += stealScore;
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

    public int getTotalScore() {
        return totalScore;
    }
}