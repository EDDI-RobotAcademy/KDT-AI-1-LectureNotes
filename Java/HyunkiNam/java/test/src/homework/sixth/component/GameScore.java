package homework.sixth.component;

public class GameScore {
    private int totalScore;
    public GameScore(int totalScore){
        this.totalScore = totalScore;
    }

    public void stealScore(GameScore gameScore, int stealScore){
        this.totalScore += stealScore;
        gameScore.totalScore -= stealScore;
    }

    public void buffScore(int buffScore){
        this.totalScore += buffScore;
    }

    public void deathScore(int deathScore){
        this.totalScore = deathScore;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
