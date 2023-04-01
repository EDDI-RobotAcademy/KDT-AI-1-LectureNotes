package homework.diceGame.game;

// 플레이어들의 게임 스코어

public class GameScore2 {
    private int gameScore;

    public GameScore2(int gameScore) {
        this.gameScore = gameScore;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void takeScore(GameScore2 otherScore, int stealScore){
        this.gameScore -= stealScore;
        otherScore.gameScore += stealScore;
    }

    public void addScore(int buffScore){
        this.gameScore += buffScore;
    }

    public void loseAll(int deathScore){
        this.gameScore = deathScore;
    }

    @Override
    public String toString() {
        return "GameScore2{" +
                "GameScore=" + gameScore +
                '}';
    }
}
