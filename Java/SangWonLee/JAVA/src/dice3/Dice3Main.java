package dice3;

public class Dice3Main {
    public static void main(String[] args) throws InterruptedException {


        DiceGameManager diceGameManager = new DiceGameManager();
        diceGameManager.addPlayer();
        diceGameManager.rollDice();
        diceGameManager.diceSum();
        diceGameManager.specialDice();
        diceGameManager.resultDice();

    }

}

