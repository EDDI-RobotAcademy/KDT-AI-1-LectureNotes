package kr.eddi.demo.homework;

import java.util.List;

public class GameScore {
    private int totalScore;

    public GameScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void takeScore(List<Player> player, int stealScore, List<Integer> playerList) {
        this.totalScore += stealScore;
        for(int i : playerList){
            player.get(i).getGameScore().totalScore -= stealScore;
        }
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