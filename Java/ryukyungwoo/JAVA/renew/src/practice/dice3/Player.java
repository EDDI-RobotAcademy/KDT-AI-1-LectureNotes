package practice.dice3;

import java.util.ArrayList;
import java.util.List;

class PlayerList{
    final private int HOW_MANY_PLAYERS = 2;
    List<Player> playerList = new ArrayList<>();
    public PlayerList () {
        for (int i = 0; i < HOW_MANY_PLAYERS; i++) {
            Player player = new Player();
            playerList.add(player);
        }
    }

    public Player getPlayerList(int index) {
        return playerList.get(index);
    }

    @Override
    public String toString() {
        return "PlayerList{" +
                "playerList=" + playerList +
                '}';
    }
}
public class Player {
    List<Dice> diceList = new ArrayList<>();
    final private int HOW_MANY_DICES = 3;
    public Player () {
        for (int i = 0; i < HOW_MANY_DICES; i++) {
            Dice dice = new Dice();
            diceList.add(dice);
        }
    }

    public Dice getDiceList(int index) {
        return diceList.get(index);
    }

    @Override
    public String toString() {
        return "Player{" +
                "diceList=" + diceList +
                '}' + '\n';
    }
}