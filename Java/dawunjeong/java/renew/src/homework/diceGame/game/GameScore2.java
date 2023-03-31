package homework.diceGame.game;

// 플레이어들의 게임 스코어

public class GameScore2 {
    private int GameScore;

    public GameScore2(int gameScore) {
        GameScore = gameScore;
    }

    public int getGameScore() {
        return GameScore;
    }

    public void takeScore(GameScore2 otherScore, int stealScore){
        this.GameScore -= stealScore;
        otherScore.GameScore += stealScore;
    }

    public void addScore(int buffScore){
        this.GameScore += buffScore;
    }

    public void loseAll(int deathScore){
        this.GameScore = deathScore;
    }

    @Override
    public String toString() {
        return "GameScore2{" +
                "GameScore=" + GameScore +
                '}';
    }
}
