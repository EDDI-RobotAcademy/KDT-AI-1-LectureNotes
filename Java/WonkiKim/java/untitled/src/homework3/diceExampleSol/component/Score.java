package homework3.diceExampleSol.component;

public class Score {
    private int totalScore;

    public Score(int totalScore) {
        this.totalScore = totalScore;
    }

    public void takeScore(Score otherScore, int steal_score) {
        this.totalScore -= steal_score;
        otherScore.totalScore += steal_score;
    }

    public void addScore(int buffScore) {
        this.totalScore += buffScore;
    }

    public void loseAll(int deathScore) {
        this.totalScore = deathScore;
    }

    public int getTotalScore(){
        return this.totalScore;
    }
    @Override
    public String toString() {
        return "Score{" +
                "totalScore=" + totalScore +
                '}';
    }


}
