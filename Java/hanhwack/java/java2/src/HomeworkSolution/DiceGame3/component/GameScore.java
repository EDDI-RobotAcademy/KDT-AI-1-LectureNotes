package HomeworkSolution.DiceGame3.component;


public class GameScore {
    private int totalScore;

    //생성자에 인자가 들어간 이유?? 플레이어가 한명이라 아니라 여러명일 수 있으므로
    //초기화를 통해 이전 플레이어의 값을 날려버리는 역할?
    //만약 생성자에 인자가 없다면 초기화 되지않고 이전값의 totalScore에서 추가적인 계산이 일어나는가?
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
