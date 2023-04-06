package practice.dice3;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Dice> diceList;
    final private int HOW_MANY_DICES = 3;
    public Player () {
        diceList = new ArrayList<>();
        for (int i = 0; i < HOW_MANY_DICES; i++) {
            diceList.add(new Dice());
        }
    }
    public Dice getDiceList(int index) {
        return diceList.get(index);
    }
    @Override
    public String toString() {
        return "Player{" +
                "diceList=" + diceList +
                '}';
    }
}
class PlayerList {
    List<Player> playerList;
    private int playerNumber;
    final private int HOW_MANY_PLAYERS = 2;
    public PlayerList () {
        playerList = new ArrayList<>();
        for (int i = 0; i < HOW_MANY_PLAYERS; i++) {
            playerList.add(new Player());
            this.playerNumber = i;
        }
    }
    public int getPlayerNumber(int index) {
        return playerNumber = index;
    }
    public Player getPlayerList(int index) {
        return playerList.get(index);
    }

    public int getHOW_MANY_PLAYERS() {
        return HOW_MANY_PLAYERS;
    }

    @Override
    public String toString() {
        return "PlayerList{" +
                "playerList=" + playerList +
                '}';
    }
}