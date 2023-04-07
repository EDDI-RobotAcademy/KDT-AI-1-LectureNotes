package homework.ranDice4.component;

public class GameScore {
    private int totalScore;

    public GameScore(int totalScore) {
        this.totalScore = totalScore;
    }

    // 점수를 빼앗rl는 메서드 인수로 상대방의 스코어와 빼앗는 스코어를 받는다
    public void takeScore(GameScore otherScore, int stealScore) {
        this.totalScore -= stealScore ;
        otherScore.totalScore += stealScore ;
    }

    public void addScore(int buffScore) {
        this.totalScore += buffScore;
    }

    public void loseAll(int deathScore) {
        this.totalScore = deathScore ;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }

}
