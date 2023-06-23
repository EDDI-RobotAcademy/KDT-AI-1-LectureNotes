package review1.dawun;

import java.util.ArrayList;
import java.util.List;

public class ReviewPlayer6 {

    final private String name;
    final private int DICE_NUM = 3;
    final private List<ReviewDice6> dice6List = new ArrayList<>();
    final private ReviewGameScore6 gameScore6;

    public ReviewPlayer6(String name) {
        this.name = name;
        int sumOfDices = rollDice2();
        gameScore6 = new ReviewGameScore6(sumOfDices);
    }

    public int rollDice2() {
        int sumOfDices = 0;

        for (int i = 0; i < DICE_NUM; i++) {
            dice6List.add(new ReviewDice6());
            sumOfDices += dice6List.get(i).getDiceNumber(i);

            if (dice6List.get(0).getDiceNumber(i) % 2 == 1) {
                break;
            }
        }
        return sumOfDices;
    }

    public ReviewDice6 getSpecialDice(int index){
        if (dice6List.size() > index) {
            return dice6List.get(index);
        }

        return null;
    }

    public ReviewGameScore6 getGameScore6() {
        return gameScore6;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player2{" +
                "name='" + name + '\'' +
                ", dice2List=" + dice6List +
                ", gamescore2=" + gameScore6 +
                '}';
    }
}
