package dice;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

class RandomDice {
    private int MAX = 6;
    private int MIN = 1;
    private int diceNumber;
    List<Dice> diceList = new ArrayList<>();

    public RandomDice() {
        for(int i = 0; i < diceNumber; i++) {
            diceList.add(CustomRandom.generateNumber(MAX,MIN));
        }
    }

    @Override
    public String toString() {
        return "RandomDice{" +
                "diceList=" + diceList +
                '}';
    }
}
public class Dice {
    public static void main(String[] args) {
        Player player = new Player();
        RandomDice randomDice = new RandomDice();
        System.out.println(player);
        System.out.println(randomDice);

    }

}