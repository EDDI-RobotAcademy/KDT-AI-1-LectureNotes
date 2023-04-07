package homework.diceGame.game;

// 플레이어들의 게임 스코어

public class GameScore2 {
    private int totalScore;

    public GameScore2(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void takeScore(GameScore2 otherScore, int stealScore){
        this.totalScore -= stealScore;
        otherScore.totalScore += stealScore;
    }

    public void addScore(int buffScore){
        this.totalScore += buffScore;
    }

    public void loseAll(int deathScore){
        this.totalScore = deathScore;
    }

    @Override
    public String toString() {
        return "GameScore2{" +
                "GameScore=" + totalScore +
                '}';
    }
}