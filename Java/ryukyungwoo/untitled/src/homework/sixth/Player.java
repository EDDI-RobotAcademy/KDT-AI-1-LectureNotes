package homework.sixth;

import java.util.ArrayList;
import java.util.List;

public class Player {
    final private int PLAYER_NUM = 2;

    List<Player> playerList = new ArrayList<Player>();

    public Player (Dice dice) {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Dice(dice.getDiceList()));
        }
    }
}
