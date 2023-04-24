package jdp1.entity;

import java.util.ArrayList;
import java.util.List;

class Player {
    List<Dice> diceList;
    final private int HOW_MANY_DICES = 3;
    private int score;
    private String name;

    public Player () {
        diceList = new ArrayList<>();
        for (int i = 0; i < HOW_MANY_DICES; i++) {
            diceList.add(new Dice());
            score += diceList.get(i).getDiceNumber();
        }
    }

    public List<Dice> getDiceList() {
        return diceList;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "diceList=" + diceList +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}' + '\n';
    }
}
public class PlayerList {
    List<Player> playerList;
    final private int HOW_MANY_PLAYERS = 2;

    public PlayerList () {
        playerList = new ArrayList<>();
        for (int i = 0; i < HOW_MANY_PLAYERS; i++) {
            playerList.add(new Player());
            playerList.get(i).setName("user: " + (i + 1));
        }
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    @Override
    public String toString() {
        return '\n' + "PlayerList{" +
                "playerList=" + '\n' + playerList +
                '}';
    }
}
