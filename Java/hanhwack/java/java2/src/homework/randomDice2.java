package homework;

class Game {


    Score score;

    Boolean game;

    public Game() {

        this.game = false;
    }

    public Boolean getGame(Score score) {
        if ((score % 4 == 0) && (score % 3 == 0)) {
            game = true;
        } else {
            game = false;
        }
        return game;
    }

    public void setGame(Boolean game) {
        this.game = game;
    }
}
class Dice {

    int diceNum;

    public Dice() {

        this.diceNum = 0;
    }

    public Integer getdNum() {
        diceNum = (int)(Math.random() * 6) + 1;
        return diceNum;
    }

    public void setdNum(Integer diceNum) {

        this.diceNum = diceNum;
    }
}

class Score {
    int score;
    int totalScore;
    Dice diceNum;

    public Score() {
        this.totalScore = 0;
        this.score = 0;
    }

    public int getScore(Dice diceNum) {
        for (int i = 0; i < 4; i++) {
            score = diceNum;
            totalScore += score;
        }

        return totalScore;
    }

    public void setScore(int totalScore) {
        this.score = totalScore;
    }
}

public class randomDice2 {
    public static void main(String[] args) {

        final Game game = new Game();
        System.out.println("현재 전구 상태: " + (game.getGame() ? "승리" : "패배"));
    }
}
