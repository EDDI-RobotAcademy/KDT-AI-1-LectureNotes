package homework;

import homework.third.diceGame4.component.Player;
import utility.random.CustomRandom;

import java.util.Arrays;

public class RealPlayer {
    int DICE_NUMBER = 3;
    String PlayerName;
    int totalScore;
    static int specialDice;
    int[] DiceArray = new int[3];
    boolean issteal=false; //훔쳤니?

    public RealPlayer(String name) {
        this.PlayerName = name;
        totalScore = rollDice();
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
        specialDice = DiceArray[2];

        switch (specialDice) {
            case 1:
                Dicesum += 3;
                issteal =true; //훔쳤어요
                break;
            case 3:
                Dicesum += 2;
                break;
            case 4:
                Dicesum = -7777;
                break;

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

    public void stolen (boolean issteal) {
        if (issteal){
        this.totalScore -= 3;
    }}

    public boolean issteal() {
        return issteal;
    }

    public static void main(String[] args) {
        RealPlayer Player1 = new RealPlayer("Player1");
        RealPlayer Player2 = new RealPlayer("Player2");
        Player2.stolen(Player1.issteal()); //Player1이 훔쳤어 true야 그럼 Player2에서 3점 뺏어와
        Player1.stolen(Player2.issteal());

        System.out.println("Player1: " + Player1);
        System.out.println("Player2: " + Player2);


        if (Player1.getTotalScore() > Player2.getTotalScore()) {
            System.out.println("플레이어1 승리");
        } else {
            System.out.println("플레이어2 승리");
        }
    }
}
