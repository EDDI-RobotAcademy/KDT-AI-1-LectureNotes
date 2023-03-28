package homework.fifth;
public class fourthGameScore {
    private int totalScore;

    public fourthGameScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void takeScore(fourthGameScore otherScore, int stealScore) {
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
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }
    public int getTotalScore() {
        return totalScore;
    }
}