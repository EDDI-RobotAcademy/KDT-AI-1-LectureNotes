package examSolve.exam1.customLibrary.diceGame;

import examSolve.exam1.customLibrary.utility.randomNumber.CustomRandomNumber;

// 문제 27번
// 총 12개의 값을 출력할 수 있는 12면체 주사위를 만들어 봅시다.
public class Dice {
    final private int MIN = 1;
    final private int MAX = 12;
    private int diceNumber;

    public Dice() {
        this.diceNumber = CustomRandomNumber.generateRandomNumber(MIN, MAX);
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    public void subtractDiceNumber() {
        diceNumber--;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
