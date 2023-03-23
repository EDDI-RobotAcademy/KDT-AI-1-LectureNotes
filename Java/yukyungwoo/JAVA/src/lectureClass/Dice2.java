package lectureClass;

class Game {
    private final int gameNumber;
    private final int COUNT = 0;
    public Game () {
      for(; COUNT < gameNumber; COUNT++)
    }
    public int getGameNumber () {
        return gameNumber
    }


}

class Dice {
    private final int diceNumber;
    private final int MAX = 6;
    private final int MIN = 1;

    public Dice () {
        this.diceNumber = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
    }
    public int getDiceNumber () {
        return diceNumber;
    }



}

class Score {
    private final int totalScore;
    public Score () {
        this.totalScore =
    }


}


public class Dice2 {
    public static void main(String[] args) {
        Game game = new Game()
    }
}
