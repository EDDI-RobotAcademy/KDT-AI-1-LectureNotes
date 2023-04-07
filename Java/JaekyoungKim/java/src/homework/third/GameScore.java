package homework.third;

public class GameScore {
    public int totalScore1;
    private int totalScore;
    public GameScore(int totalScore) {
        this.totalScore = totalScore;
    }
    public void takeScore(GameScore otherScore, int stealScore){
        this.totalScore -= stealScore;
        otherScore.totalScore+=stealScore;
    }
    public void addScore(int buffScore){
        this.totalScore+=buffScore;
    }
    public void loseAll(int deathScore){
        this.totalScore=deathScore;
    }


    @Override
    public String toString() {
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }

    public int getTotalScore() {
        return totalScore;
    }
}