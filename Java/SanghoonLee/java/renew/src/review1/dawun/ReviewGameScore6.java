package review1.dawun;

public class ReviewGameScore6 {
    // 변수명 이슈
    //private int GameScore;
    private int gameScore;

    public ReviewGameScore6(int gameScore) {
        this.gameScore = gameScore;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void takeScore(ReviewGameScore6 otherScore, int stealScore){
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
