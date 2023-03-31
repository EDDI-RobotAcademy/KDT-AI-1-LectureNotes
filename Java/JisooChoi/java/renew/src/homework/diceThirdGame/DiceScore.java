package homework.diceThirdGame;

public class DiceScore {
    private int totalScore = 0;

    public DiceScore() {}

    public int totalScore(int score){
        this.totalScore += score;
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void setSteal(int plus){
        this.totalScore += plus;
    }

    public void loseSteal(int subtraction){
        this.totalScore -= subtraction;
    }

    public void setBuff(int selfPlus){
        this.totalScore += selfPlus;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return "DiceScore{" +
                "totalScore=" + totalScore +
                '}';
    }
}
