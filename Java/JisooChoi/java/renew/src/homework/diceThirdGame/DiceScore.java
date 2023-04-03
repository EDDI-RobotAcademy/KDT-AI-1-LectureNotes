package homework.diceThirdGame;

public class DiceScore {
    private int totalScore = 0;

    public DiceScore(){}

    public int totalDiceScore(int totalScore){
        this.totalScore += totalScore;
        return totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void stealScore(int totalScore) {
        this.totalScore += 3;
    }

    public void lostScore(int totalScore) {
        this.totalScore -= 3;
    }

    public void buffScore(int totalScore) {
        this.totalScore += 2;
    }

    public void deathScore(int totalScore) {
        this.totalScore = -777;
    }

    @Override
    public String toString() {
        return "Score{" +
                "totalScore=" + totalScore +
                '}';
    }
}
