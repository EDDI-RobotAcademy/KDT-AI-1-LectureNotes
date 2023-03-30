package practice.dice3;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;
class PlayerRollingDice {
    final private int rollingDice = 3;
    List<Integer> playerRollingDiceList = new ArrayList<>();

    public PlayerRollingDice () {
        for (int i = 0; i < rollingDice; i++){
            Dice dice = new Dice();
            playerRollingDiceList.add(dice.getDiceNumber());
        }
    }

    @Override
    public String toString() {
        return "PlayerRollingDice{" +
                "playerRollingDiceList=" + playerRollingDiceList +
                '}';
    }
}

public class Player {
    final private int playerNumber = 2;
    List<List> playerNumberList = new ArrayList<>();

    public Player () {
        for (int i = 0; i < playerNumber; i++){
            PlayerRollingDice playerRollingDice = new PlayerRollingDice();
            playerNumberList.add(playerRollingDice.playerRollingDiceList);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerNumberList=" + playerNumberList +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Player());
    }
}
