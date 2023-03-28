package homework3;

import java.util.ArrayList;

class Game {
    final private int[] rounds;
    final private Player player1;
    final private Player player2;

    public Game() {
        player1 = new Player();
        player2 = new Player();
        rounds = new int[]{0, 1, 2};
    }

    public void play() {
        for (int round : rounds) {
            switch (round) {
                case 0 -> playRound1();
                case 1 -> playRound2();
                case 2 -> playRound3();
            }
        }
    }

    public void playRound1() {
        player1.rollDice(new Dice());
        player2.rollDice(new Dice());
    }

    public void playRound2() {

        if (player1.isQualification()) {
            player1.rollDice(new Dice());
        }
        ;
        if (player2.isQualification()) {
            player2.rollDice(new Dice());
        }
        ;
    }

    public void playRound3() {

        boolean diceOne1 = false;
        boolean diceOne2 = false;

        if (player1.isQualification()) {
            diceOne1 = player1.rollDice(new SpecialDice());

        }

        if (player2.isQualification()) {
            diceOne2 = player2.rollDice(new SpecialDice());
            if (diceOne2) {
                player2.loseScore();
            }
        }
        if (diceOne1) {
            player2.loseScore();
        }
    }

    public void result() {
        final int defeat = -100;
        System.out.println("plyer1의 점수:" + player1);
        System.out.println("plyer2의 점수:" + player2);
        if ((player1.getTotalScore() < defeat) && (player2.getTotalScore() < defeat)) {
            System.out.println("두 플레이어 모두 세번째 주사위에서 무승부입니다.");
            return;
        }
        if (player1.getTotalScore() > player2.getTotalScore()) {
            System.out.println("player1이 승리하였습니다.");
        }
        if (player1.getTotalScore() < player2.getTotalScore()) {
            System.out.println("player2가 승리하였습니다.");
        }
        if (player1.getTotalScore() == player2.getTotalScore()) {
            System.out.println("무승부입니다.");
        }
    }

}

class Player {
    final private Score score;

    public Player() {
        score = new Score();
    }

    public boolean rollDice(Dice dice) {
        score.record(dice);
        return dice.getDiceNumber() == 1;
    }

    public int getTotalScore() {
        return score.getTotalScore();
    }

    @Override
    public String toString() {
        return score.toString();
    }

    public boolean isQualification() {
        return this.score.isQualification();
    }

    public void loseScore() {
        this.score.loseScore();
    }
}

class Score {
    final private ArrayList<Integer> scoreBoard;
    final int diceOneBonus = 3;
    final int diceThreeBonus = 2;
    final int diceFourDie = -999;
    final int indexOfSpecialDice = 2;

    public Score() {
        scoreBoard = new ArrayList<>();
    }

    public void loseScore() {
        scoreBoard.set(scoreBoard.size() - 1, scoreBoard.get(scoreBoard.size() - 1) - diceOneBonus);
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (int score : scoreBoard) {
            totalScore += score;
        }
        return totalScore;
    }

    public void record(Dice dice) {

        scoreBoard.add(dice.getDiceNumber());


        ;

        if (dice instanceof SpecialDice) {
            switch (dice.getDiceNumber()) {

                // 점수 뺏는 기능.......미구현  -> 구현하긴 했는데 Game.playround3 메소드와 Score.record메소드에서 나눠서 구현...
                // 한가지 기능이 두 클래스에 나눠져서 구현되는게 적절하지 않은것 같음.
                case 1 -> scoreBoard.set(indexOfSpecialDice, dice.getDiceNumber() + diceOneBonus);
                case 3 -> scoreBoard.set(indexOfSpecialDice, dice.getDiceNumber() + diceThreeBonus);
                case 4 -> scoreBoard.set(indexOfSpecialDice, diceFourDie);

            }

        }
    }

    public boolean isQualification() {
        return this.scoreBoard.get(0) % 2 == 0;
    }

    @Override
    public String toString() {
        return scoreBoard.toString() + "  Total Score : " + getTotalScore();
    }
}

class Dice {
    final private static int DICE_MAX = 6;
    final private static int DICE_MIN = 1;
    final private int diceNumber;

    public Dice() {
        this.diceNumber = randomNumber();
    }

    public int getDiceNumber() {
        return this.diceNumber;
    }

    private static int randomNumber() {
        return (int) (Math.random() * (DICE_MAX - DICE_MIN + 1)) + DICE_MIN;
    }

}

class SpecialDice extends Dice {
}

public class diceExample {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
        game.result();
    }
}
