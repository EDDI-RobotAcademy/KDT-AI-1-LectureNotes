package homework.diceFourthGame;

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

    public void stealScore() {
        this.totalScore += 3;
    }

    public void lostScore() {
        this.totalScore -= 3;
    }

    public void buffScore() {
        this.totalScore += 2;
    }

    public void deathScore() {
        this.totalScore = -777;
    }

    @Override
    public String toString() {
        return "Score{" +
                "totalScore=" + totalScore +
                '}';
    }
}
