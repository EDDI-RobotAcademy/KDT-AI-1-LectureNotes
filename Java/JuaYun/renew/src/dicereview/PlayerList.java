package dicereview;

import javax.management.relation.RelationNotification;
import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private int PLAYER_NUM = 2;
    private String name;
    List<List<Integer>> playerList = new ArrayList<>();

    public PlayerList(String name) {
        this.name = name;
    }

    public PlayerList() {
        final int DICE_NUMBER = 3;

        for (int i = 0; i < PLAYER_NUM; i++) {
            RandomDiceList randomDiceList = new RandomDiceList(DICE_NUMBER);
            playerList.add(randomDiceList.getDiceList());
        }
    }

    @Override
    public String toString() {
        return "PlayerList{" +
                "playerList=" + playerList +
                '}';
    }
}
