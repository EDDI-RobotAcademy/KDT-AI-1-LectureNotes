package homework.diceGame.game;

import java.util.ArrayList;
import java.util.List;

public class Player2 {

    final private String name;
    final private int DICE_NUM = 3;
    final private List<Dice2> dice2List = new ArrayList<>();
    final private GameScore2 gamescore2;

    public Player2(String name) {
        this.name = name;
        int sumOfDices = rollDice2();
        gamescore2 = new GameScore2(sumOfDices);

    }

    public int rollDice2() {

        int sumOfDices = 0;

        for (int i = 0; i < DICE_NUM; i++) {
            dice2List.add(new Dice2());
            sumOfDices += dice2List.get(i).getDiceNumber(i);

            if (dice2List.get(0).getDiceNumber(i) % 2 == 1) {
                break;
            }
        }
        return sumOfDices;
    }

    public Dice2 getSpecialDice(int index){
        if (dice2List.size() > index) {
            return dice2List.get(index);
        }

        return null;
    }

    public GameScore2 getGamescore2() {
        return gamescore2;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player2{" +
                "name='" + name + '\'' +
                ", dice2List=" + dice2List +
                ", gamescore2=" + gamescore2 +
                '}';
    }
}