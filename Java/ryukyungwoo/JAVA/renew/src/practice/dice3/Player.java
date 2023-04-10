package practice.dice3;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Dice> diceList;
    private int diceSum;
    final private int HOW_MANY_DICES = 3;
    public Player () {
        diceList = new ArrayList<>();
        this.diceSum = 0;
        for (int i = 0; i < HOW_MANY_DICES; i++) {
            diceList.add(new Dice());
            diceSum += diceList.get(i).getDiceNumber();
            if(!OddDecision(diceList.get(i).getDiceNumber())) {
                break;
            }
        }
    }
    public Boolean OddDecision (int diceNumber) {
        final int ODD_CHECK = 2;
        if(diceNumber % 2 ==0) {
            return true;
        }
        return false;
    }

    public List<Dice> getDiceList() {
        return diceList;
    }

    public int getDiceSum() {
        return diceSum;
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
            playerNumber = i;
        }
    }
    public int getPlayerNumber(int index) {
        return playerNumber = index;
    }


    public int getHOW_MANY_PLAYERS() {
        return HOW_MANY_PLAYERS;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    @Override
    public String toString() {
        return "PlayerList{" +
                "playerList=" + playerList +
                '}';
    }
}