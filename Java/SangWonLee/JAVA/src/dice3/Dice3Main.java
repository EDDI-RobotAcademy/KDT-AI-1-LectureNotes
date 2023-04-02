package dice3;

import java.util.*;

public class Dice3Main {
    public static void main(String[] args) {

        Player playerList = new Player();
        playerList.addPlayer();

        Dice dice = new Dice(playerList.playerName);
        dice.rollDice();
        dice.diceSumList();
//        dice.specialDiceList();






//        System.out.println("결과 → " + .totalScore.get(0) + "  :  " + special.totalScore.get(1));

        Versus vs = new Versus();

//        vs.pandan(special.totalScore,playerList.playerName1,playerList.playerName2);


    }


}

