package homework;

import homework.third.diceGame4.component.Player;
import utility.random.CustomRandom;

import java.util.Arrays;

public class RealPlayer {
    int DICE_NUMBER = 3;
    String PlayerName;
    int totalScore;
    int specialDice;
    int[] DiceArray = new int[3];

    public RealPlayer(String name) {
        this.PlayerName = name;
        totalScore = rollDice();



    }

    private int specialThirdDice() {
        specialDice = DiceArray[2];
        DiceArray[2] = CustomRandom.generateNumber(1, 6);
        if (specialDice == 4) {
            totalScore = -777;
        }
        return specialDice;
    }


    public int rollDice() {
        int Dicesum = 0;
        for (int i = 0; i < DiceArray.length; i++) {
            if (DiceArray[0] % 2 != 0) {
                break;
            }



            DiceArray[i] = CustomRandom.generateNumber(1, 6);
            Dicesum += DiceArray[i];
        }
        return Dicesum;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return "RealPlayer{" +
                "PlayerName='" + PlayerName + '\'' +
                ", DiceArray=" + Arrays.toString(DiceArray) +
                ", totalScore=" + totalScore +
                '}';
    }


    public static void main(String[] args) {
        RealPlayer Player1 = new RealPlayer("Player1");
        RealPlayer Player2 = new RealPlayer("Player2");
        System.out.println("Player1: " + Player1);
        System.out.println("Player2: " + Player2);



        if (Player1.getTotalScore() > Player2.getTotalScore()) {
            System.out.println("플레이어1 승리");
        } else {
            System.out.println("플레이어2 승리");
        }
    }
}
