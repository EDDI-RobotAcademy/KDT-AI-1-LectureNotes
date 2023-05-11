package practice.dice3.diceGame3BackLogPractice;

public class Score {
    private int totalScore;

    public Score(int totalScore) {
        this.totalScore = totalScore;
    }

    public void loseAll(int deathScore) {
        this.totalScore = deathScore;
    }

    public void addScore(int buffScore) {
        this.totalScore += buffScore;
    }

    public void takeScore(Score otherScore, int stealScore) {
        this.totalScore -= stealScore;
        otherScore.totalScore += stealScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return "{" +
                "totalScore=" + totalScore +
                '}';
    }
}
