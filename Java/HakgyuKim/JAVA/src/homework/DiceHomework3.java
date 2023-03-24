package homework;

import java.util.Arrays;

class Dice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNum;

    public Dice() {
        this.diceNum = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
    }

    public int getDiceNum() {
        return diceNum;
    }
}

class Game {

    final private int MAX_DICE = 3;
    final private int LOSE = -100;
    private Dice[] player1DiceArray;
    private Dice[] player2DiceArray;
    final private Score player1Score;
    final private Score player2Score;

    public Score getPlayer1Score() {
        return player1Score;
    }

    public Score getPlayer2Score() {
        return player2Score;
    }

    public Game() {
        this.player1DiceArray = new Dice[MAX_DICE];
        this.player2DiceArray = new Dice[MAX_DICE];
        int player1DiceSum = 0;
        int player2DiceSum = 0;

        for (int i = 0; i < player1DiceArray.length; i++) {
            player1DiceArray[i] = new Dice();
            if (player1DiceArray[0].getDiceNum() % 2 == 0) {
                player1DiceSum += player1DiceArray[0].getDiceNum();
            }

            // 첫 주사위가 짝수면 가동하고 홀수면 가동하지 않는 것 같은데 되게 하는법을 모르겠습니다.

            else {
                player1DiceSum = player1DiceArray[0].getDiceNum() +
                        player1DiceArray[1].getDiceNum() +
                        player1DiceArray[2].getDiceNum();
                switch(player1DiceArray[2].getDiceNum()) {
                    case 1:
                        player1DiceSum += 3;
                        player2DiceSum -= 3;
                        break;

                    case 3:
                        player1DiceSum += 2;
                        break;

                    case 4:
                        player1DiceSum = LOSE;
                        break;
                }

            }

        }

        for (int i = 0; i < player2DiceArray.length; i++) {
            player2DiceArray[i] = new Dice();
            if (player2DiceArray[0].getDiceNum() % 2 == 0) {
                player2DiceSum += player2DiceArray[0].getDiceNum();
            }
            else {
                player2DiceSum = player2DiceArray[0].getDiceNum() +
                                 player2DiceArray[1].getDiceNum() +
                                 player2DiceArray[2].getDiceNum();
                switch(player2DiceArray[2].getDiceNum()) {
                    case 1:
                        player1DiceSum -= 3;
                        player2DiceSum += 3;
                        break;

                    case 3:
                        player2DiceSum += 2;
                        break;

                    case 4:
                        player2DiceSum = LOSE;
                        break;
                }

            }
        }
        this.player1Score = new Score(player1DiceSum);
        this.player2Score = new Score(player2DiceSum);
    }
}

    class Score {
        final private int totalScore;

        public Score(int totalScore) {
            this.totalScore = totalScore;
        }

        public int getTotalScore() {
            return totalScore;
        }
    }

    class GameSetter {
    public static String winnerName(String player1, String player2, int player1Score, int player2Score) {
        String winner;
        if(player1Score == -100) {
            winner = player2;
        } else if(player2Score == -100) {
            winner = player1;
        } else if(player1Score > player2Score) {
            winner = player1;
        } else if(player2Score > player1Score) {
            winner = player2;
        } else {
            winner = "무승부";
        }
        return winner;
    }


    }

    public class DiceHomework3 {
        public static void main(String[] args) {

            String player1 = "철수";
            String player2 = "영희";

            Game game = new Game();
            int player1Score = game.getPlayer1Score().getTotalScore();
            int player2Score = game.getPlayer2Score().getTotalScore();
            System.out.println(player1 + " 점수는: " + player1Score);
            System.out.println(player2 + " 점수는: " + player2Score);
            System.out.println("승자는: " + GameSetter.winnerName(player1,player2,player1Score,player2Score));

        }
    }

