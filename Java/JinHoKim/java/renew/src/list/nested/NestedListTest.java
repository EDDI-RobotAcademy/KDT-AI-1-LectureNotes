package list.nested;

import diceGame.game.Dice;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class NestedListTest {
    public static void main(String[] args) {

        // Player == List<Dice>
        List<Integer> numberList = new ArrayList<>();
        // List<Player> == List<List<Dice>>
        List<List<Integer>> managedPlayerList = new ArrayList<>();

        final int PLAYER_NUM = 2;
        final int DICE_NUM = 3;

        for (int i = 0; i < PLAYER_NUM; i++) {
            for (int j = 0; j < DICE_NUM; j++) {
                numberList.add(CustomRandom.generateNumber(1, 6));
            }
            managedPlayerList.add(numberList);
        }

        for (int i = 0; i < PLAYER_NUM; i++) {
            for (int j = 0; j < DICE_NUM; j++) {
                System.out.println("nested List: " + managedPlayerList.get(i).get(j));
            }
            System.out.println();
        }
    }
}
