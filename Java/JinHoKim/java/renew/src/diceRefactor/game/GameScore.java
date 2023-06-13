package diceRefactor.game;

public class GameScore {
    private int totalScore;

    public GameScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void takeScore(GameScore otherScore, int stealScore) {
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
