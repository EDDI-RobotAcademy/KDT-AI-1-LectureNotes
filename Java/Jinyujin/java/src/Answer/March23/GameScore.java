package Answer.March23;

public class GameScore {
    private int totalScore;

    public GameScore(int totalScore) { //생성자: alt+insert
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }
}
