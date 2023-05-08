package practice.dice3.diceGame3BackLogPractice3.score;

public class GameScore {

    private int totalScore;

    public int getTotalScore() {
        return totalScore;
    }

    public GameScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void addScore(int buffScore) {
        this.totalScore += buffScore;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }

    public void deathScore(int deathScore) {
        this.totalScore = deathScore;
    }

    public void stealScore(GameScore otherScore, int stealScore) {
        this.totalScore += stealScore;
        otherScore.totalScore -= stealScore;
    }
}
