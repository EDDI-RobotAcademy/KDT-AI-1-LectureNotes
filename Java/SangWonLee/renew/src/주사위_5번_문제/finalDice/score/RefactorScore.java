package 주사위_5번_문제.finalDice.score;

public class RefactorScore {
    private int totalScore;

    public RefactorScore(int totalScore) {
        this.totalScore = totalScore;
    }


    public void takeScore(RefactorScore otherScore, int stealScore) {
        this.totalScore -= stealScore;
        otherScore.totalScore += stealScore;
    }

    public void addScore(int buffScore) {
        this.totalScore += buffScore;
    }

    public void loseAll(int deathScore) {
        this.totalScore = deathScore;
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