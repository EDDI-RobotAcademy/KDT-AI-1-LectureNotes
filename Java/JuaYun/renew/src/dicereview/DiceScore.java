package dicereview;

public class DiceScore {
    private int totalScore;

    public DiceScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "DiceScore{" +
                "totalScore=" + totalScore +
                '}';
    }
}
