package kr.eddi.demo.lectureClass.vue.controller.form;

import java.util.ArrayList;

class Player {
    ArrayList<Dice> playerList = new ArrayList<>();
    public Player () {
        for (int i = 0; i < 2; i++) {
            playerList.add(i);
        }
    }
}
public class Controller {
    DiceList diceList = new DiceList();
    Player player;
    public Controller () {
        player = new Player();
        for (int i = 0; i < 2; i++) {
            player.playerList.get(i) = diceList.getDiceList();
        }
    }
}
