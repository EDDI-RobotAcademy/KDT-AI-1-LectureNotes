package repacktoring;

class Score {
    private int totalScore;

    public Score(int diceNumberSum) {

    }


    public void Score(int totalScore) {
        this.totalScore = totalScore;
    }

    public void takeScore(Score otherScore, int stealScore) {
        this.totalScore = stealScore;
        otherScore.totalScore += stealScore;
    }

    public void buffScore(int buffScore) {
        this.totalScore += buffScore;
    }

    public void Death(int DeathScore) {
        this.totalScore = DeathScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "totalScore=" + totalScore +
                '}';
    }

    public int getTotalScore() {
        return totalScore;
    }
}
