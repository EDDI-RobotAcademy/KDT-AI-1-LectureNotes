package dice;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int DICE_NUM = 3;
    List<Integer> playerList = new ArrayList<Integer>();

    public Player() {
        for (int i = 0; i < DICE_NUM; i++) {
            playerList.add(i);
        }
    }

    public void setDICE_NUM(int DICE_NUM) {
        this.DICE_NUM = DICE_NUM;
    }
}