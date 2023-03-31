package homework.diceThirdGame;

public class DiceScore {
    private int totalScore = 0;

    public DiceScore() {}

    public int totalScore(int score){
        this.totalScore += score;
        return totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return "DiceScore{" +
                "totalScore=" + totalScore +
                '}';
    }
}
