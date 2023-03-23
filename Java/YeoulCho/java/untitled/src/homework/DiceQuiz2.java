package homework;


class Dice2 {
    int MAX = 6;
    int MIN = 1;
    int diceNumber ;

    public Dice2() {
        int diceNumber = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
        this.diceNumber = diceNumber;

    }

    public int getDiceNumber() {

        return diceNumber;

    }



    public void setDiceNumber(int diceNumber) {

        this.diceNumber = diceNumber;

    }

}

public class DiceQuiz2 {

    public static void main(String[] args) {

        Dice2 Num1 = new Dice2();

        Dice2 Num2 = new Dice2();

        Dice2 Num3 = new Dice2();

        Dice2 Num4 = new Dice2();

        int Dice_score = Num1.diceNumber + Num2.diceNumber + Num3.diceNumber + Num4.diceNumber;
        System.out.println("Num1: " + Num1.diceNumber);
        System.out.println("Num2: " + Num2.diceNumber);
        System.out.println("Num3: " + Num3.diceNumber);
        System.out.println("Num4: " + Num4.diceNumber);
        System.out.println("Dice_score: " + Dice_score);

        if (Dice_score % 3 == 0 || Dice_score % 4 == 0) {

            System.out.println("Victory");

        } else {

            System.out.println("Lose");

        }

    }
}