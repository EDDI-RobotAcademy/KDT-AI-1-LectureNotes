package writerForm.diceGame;

public class DiceScore {
    private int totalScore = 0;

    public DiceScore(){}

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore += totalScore;
    }

    public void setDeath(int death){

    }
}
