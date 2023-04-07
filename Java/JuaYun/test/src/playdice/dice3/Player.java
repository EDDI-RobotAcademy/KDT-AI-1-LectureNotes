package playdice.dice3;

import playdice.dice3.GameDice;
import utility.CustomRandom;

import java.util.ArrayList;
import java.util.List;

class DiceGameSet {

}
public class Player {
    public static void main(String[] args) {
        final int MAX_DICE_NUMBER = 3;

        List<GameDice> gameDiceList = new ArrayList<>();

        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            GameDice.add(new GameDice(CustomRandom.generateNumber(i)));
        }
        System.out.println(GameDice);
    }
}
