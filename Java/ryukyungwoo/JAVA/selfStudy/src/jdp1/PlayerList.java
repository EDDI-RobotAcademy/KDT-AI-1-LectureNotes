package jdp1;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    List<Player> playerList;
    private String name;
    final private int HOW_MANY_PLAYERS = 2;
    public PlayerList () {
        playerList = new ArrayList<>();
        for (int i = 0; i < HOW_MANY_PLAYERS; i++) {
            playerList.add(new Player());
            name = "플레이어" + (i + 1);
        }
    }

    public List<Player> getPlayerList() {

        return playerList;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PlayerList{" +
                "playerList=" + playerList +
                ", name='" + name + '\'' +
                '}';
    }
}
