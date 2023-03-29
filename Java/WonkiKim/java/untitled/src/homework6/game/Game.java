package homework6.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    final private List<Player> playerList = new ArrayList<>();
    final private Score score;
    final private List<Integer> SPECIAL_ROUND = new ArrayList<>(Arrays.asList(2));

    public Game(int playerNumber) {
        score = new Score(playerNumber);
        for (int i = 0; i < playerNumber; i++) {
            addPlayer(new Player(i));

        }
    }

    private void addPlayer(Player player) {
        playerList.add(player);
    }

    public void play(int totalRound) {
        for (int i = 0; i < totalRound; i++) {
            playRound(i);
        }
    }

    private void playRound(int round) {
        for (Player player : playerList) {
            if (round > 0 && !score.isQualify(playerList.indexOf(player))) {
                continue;
            } else if (SPECIAL_ROUND.contains(round)) {
                specialRound(player);
            } else {
                nomalRound(player);
            }
        }
    }

    private Dice nomalRound(Player player) {
        final Dice dice = new Dice();
        player.roll(dice);
        score.record(dice, playerList.indexOf(player));
        return dice;
    }

    private Dice specialRound(Player player) {
        final Dice dice = nomalRound(player);
        score.specialRoundEvent(playerList.indexOf(player));
        return dice;
    }

    public void result() {
        for (int i = 0; i < playerList.size(); i++) {
            System.out.print(playerList.get(i));
            System.out.print("  ///  ");
            System.out.print(score.getScoreBoard(i));
            System.out.print("  ///  ");
            System.out.println(score.getTotalScore(i));
        }
        checkWin();
    }

    private void checkWin() {
        int totalScoreOfPlayer1 = score.getTotalScore(0);
        int totalScoreOfPlayer2 = score.getTotalScore(1);

        if (totalScoreOfPlayer1 > totalScoreOfPlayer2) {
            System.out.println("player1 Win");
        } else if (totalScoreOfPlayer1 < totalScoreOfPlayer2) {
            System.out.println("player2 Win");
        } else {
            System.out.println("TIE.");
        }
    }
}
