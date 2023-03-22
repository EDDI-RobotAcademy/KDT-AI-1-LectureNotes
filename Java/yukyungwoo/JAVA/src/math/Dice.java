package math;

public class Dice {
    public static void main(String[] args) {
        final int randomDice1 = (int) (Math.random() * 6 ) + 1;
        System.out.println("randomDice1 = " + randomDice1);

        final int randomDice2 = (int) (Math.random() * 6 ) + 1;
        System.out.println("randomDice2 = " + randomDice2);

        int sumDice = (randomDice1 + randomDice2);
        System.out.println("sumDice = " + sumDice);

        if (sumDice % 4 == 0) {
            System.out.println("승리");

        }else {
                System.out.println("패배");
            }









    }
}
