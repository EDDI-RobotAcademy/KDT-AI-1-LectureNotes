package practice.dice3BackLog2.score;

public class Score {

    private int totalScore;

    public Score(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void addScore(int buffScore) {
        this.totalScore += buffScore;
    }

    public void deathScore(int deathScore) {
        this.totalScore = deathScore;
    }

    public void stealScore(Score otherScore,int stealScore) {
        this.totalScore += stealScore;
        otherScore.totalScore -= stealScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "totalScore=" + totalScore +
                '}';
    }
}
