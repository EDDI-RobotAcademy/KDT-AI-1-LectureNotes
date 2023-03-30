package homework.diceThirdGame;

public class DiceScore {
    int totalScore = 0;

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
