package practiceDice3;

import java.util.ArrayList;
import java.util.List;

public class Player {
    int DICE_NUMBER = 3;
    List<Integer> diceList = new ArrayList<>();

    public Player() {
        for (int i = 0; i < DICE_NUMBER; i++) {
            Dice3 dice3 = new Dice3();
            diceList.add(dice3.getDiceNumber());
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "diceList=" + diceList +
                '}';
    }
}

class PlayerList {
    int PLAYER_NUMBER = 2;
    List<Player> playerList = new ArrayList<>();

    public PlayerList() {
        for (int i = 0; i < PLAYER_NUMBER; i++) {
            Player player = new Player();
            playerList.add(player);
        }
    }

    @Override
    public String toString() {
        return "PlayerList{" +
                "playerList=" + playerList +
                '}';
    }

    public static void main(String[] args) {
        PlayerList playerList1 = new PlayerList();
        System.out.println(playerList1);
    }
}