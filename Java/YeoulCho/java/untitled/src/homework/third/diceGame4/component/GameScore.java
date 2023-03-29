package homework.third.diceGame4.component;

public class GameScore { //총 게임점수, 상대편게임점수 뺏기, 플러스점수,무조건패배)

    private int totalScore;

    public GameScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void takeScore(GameScore otherScore, int stealScore){ //상대편점수, 뺏은점수
        this.totalScore -= stealScore; // 총합에서 - 뺏은점수
        otherScore.totalScore += stealScore; //상대점수의 총합점수 + 뺏은점수
    }
    public void addScore(int buffScore){ //버프스코어 넣으면 점수를 플러스하겠다.

         this.totalScore += buffScore; //총점수 + 버프점수
    }
    public void death(int deathScore){ //죽음, 패배

        this.totalScore += deathScore; //총점수 = 패배점수
    }
    public int getTotalScore(){
        return totalScore;  // 총점수가져와라
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }
}
