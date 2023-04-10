package problems.prob27;

import java.util.ArrayList;
import java.util.List;

public class Player {
    final private String name;
    List<Dice> diceList = new ArrayList<>();
    private int health = 10;

    public Player(String name) {
        this.name = name;
        for (int i = 0 ; i < 10; i++) {
            diceList.add(new Dice());
        }
    }

    public String getName() {
        return name;
    }

    public List<Dice> getDiceList() {
        return diceList;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                '}';
    }
}
