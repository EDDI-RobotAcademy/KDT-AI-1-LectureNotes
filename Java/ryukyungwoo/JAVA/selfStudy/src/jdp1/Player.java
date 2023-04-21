package jdp1;

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
    public List<Dice> getDiceList() {
        return diceList;
    }

    @Override
    public String toString() {
        return "Player{" +
                "diceList=" + diceList +
                '}';
    }
}
