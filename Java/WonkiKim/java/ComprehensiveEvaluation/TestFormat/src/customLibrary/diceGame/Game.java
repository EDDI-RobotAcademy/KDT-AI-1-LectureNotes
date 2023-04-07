package customLibrary.diceGame;


import customLibrary.diceGame.component.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    final private int NUMBER_OF_PLAYER = 10;
    private List<Player> playerList = new ArrayList<>();

    public void addPlayer() {
        for (int i = 0; i < NUMBER_OF_PLAYER; i++) {
            playerList.add(new Player());
        }
    }

    public void play() {
        for (Player player : playerList) {
            player.play();
        }
        for (Player player : playerList) {
            player.attack(playerList);
        }
    }

    public void printResult() {
        Collections.sort(playerList);


        int tie = 1;
        int tieScore = 13;
        for (int i = 1; i < playerList.size() + 1; i++) {
            Player player = playerList.get(i - 1);

            if (!(player.getScore() == tieScore)) {
                tie = i;
                tieScore = player.getScore();
            }
            if (tieScore == 0) {
                System.out.println("중간 탈락자 " + player);
                continue;
            }
            System.out.println(tie + "등" + player);
        }
    }

}
