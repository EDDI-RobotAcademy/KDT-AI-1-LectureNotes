package mamber.Dice;

public class Score {
    private int totalScore;

    public Score(int totalScore) {
        this.totalScore = totalScore;
    }

    public void takeScore(Score otherScore, int stealScore){
        this.totalScore -= stealScore;
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
        return "Score{" +
                "totalScore=" + totalScore +
                '}';
    }
    public int getTotalScore() {
        return totalScore;
    }
}
