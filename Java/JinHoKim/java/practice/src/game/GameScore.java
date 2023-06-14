package game;

public class GameScore {
    private int totalScore;

    public GameScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }
}
