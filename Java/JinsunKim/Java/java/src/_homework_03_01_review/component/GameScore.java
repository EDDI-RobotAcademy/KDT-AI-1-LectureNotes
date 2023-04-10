package _homework_03_01_review.component;

public class GameScore {

    //인자를 설정하는 경우는
    //결국 외부에서 점수 값을 입력 받겠다는 것을 의미합니다.
    //왜냐하면 주사위 값들을 계산해서
    //그 결과로 점수 객체를 만들 것이기 때문에 그렇습니다.

    private int totalScore;

    public GameScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void takeScore(GameScore otherScore, int stealScore) {
        this.totalScore -= stealScore;
        otherScore.totalScore += stealScore;
    }

    public void addScore(int buffScore) {
        this.totalScore += buffScore;
    }

    public void loseAll(int deathScore) {
        this.totalScore = deathScore;
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
