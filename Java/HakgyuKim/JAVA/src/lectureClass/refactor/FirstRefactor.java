package lectureClass.refactor;

import utility.random.CustomRandom;

import java.util.Arrays;

class FirstRefactorGame {
    int MAX_DICE_NUMBER = 3;
    int MAX = 6;
    int MIN = 1;
    int diceSum = 0;
    int[] diceNumberArray;

    @Override
    public String toString() {
        return "FirstRefactorGame{" +
                "diceSum=" + diceSum +
                ", diceNumberArray=" + Arrays.toString(diceNumberArray) +
                '}';
    }

    public FirstRefactorGame() {


        diceNumberArray = new int[MAX_DICE_NUMBER];
        rollDice();
        sumDiceNumber();
       /* for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            diceNumberArray[i] = CustomRandom.generateNumber(MIN, MAX);
            diceSum += diceNumberArray[i];
        */
    }

    public void sumDiceNumber() {
        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            diceSum += diceNumberArray[i];
            System.out.println(diceSum);
        }
    }


    public void rollDice() {
        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            diceNumberArray[i] = CustomRandom.generateNumber(MIN, MAX);
        }


    }

        public void checkWin () {
            if ((diceSum % 3 == 0) || (diceSum % 4 == 0)) {
                System.out.println("승리!");
            } else
                System.out.println("패배!");

        }
    }


public class FirstRefactor {
    public static void main(String[] args) {

        FirstRefactorGame frgame = new FirstRefactorGame();
        frgame.checkWin();

        System.out.println(frgame);
    }
}
