package homework.diceThirdGame;

public class DiceScore {
    private int totalScore = 0;

    public DiceScore() {}

    public DiceScore(int totalScore){
        this.totalScore += totalScore;
    }

    @Override
    public String toString() {
        return "DiceScore{" +
                "totalScore=" + totalScore +
                '}';
    }
}
