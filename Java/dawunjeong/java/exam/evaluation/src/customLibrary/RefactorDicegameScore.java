package customLibrary;

public class RefactorDicegameScore {
    private int totalScore;

    public RefactorDicegameScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void takeScoreEvenplayer(RefactorDicegameScore otherScore, int stealScore) {
        this.totalScore -= stealScore;
        otherScore.totalScore += stealScore;
    }

    public void takeScoreOddplayer(RefactorDicegameScore otherScore, int stealScore) {
        this.totalScore -= stealScore;
        otherScore.totalScore += stealScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }
}
