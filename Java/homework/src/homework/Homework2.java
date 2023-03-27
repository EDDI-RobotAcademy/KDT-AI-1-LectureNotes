package homework;

class Dice {
    final int MAX = 6;
    final int MIN = 1;
    final int diceValue = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
    public Dice() {
    }
    public int getDiceValue() {
        return diceValue;
    }
}
public class Homework2 {
    
    public static void main(String[] args) {
        final Dice d1 = new Dice();
        final Dice d2 = new Dice();
        final Dice d3 = new Dice();
        final Dice d4 = new Dice();

        int diceValue = (d1.diceValue + d2.diceValue + d3.diceValue + d4.diceValue);

        final int winnerkey1 = 4;
        final int winnerkey2 = 3;

        System.out.println("d1 = " + d1.diceValue);
        System.out.println("d2 = " + d2.diceValue);
        System.out.println("d3 = " + d3.diceValue);
        System.out.println("d4 = " + d4.diceValue);
        System.out.println("d1 + d2 + d3 + d4 = " +
                (d1.diceValue + d2.diceValue + d3.diceValue + d4.diceValue));

        if (diceValue % winnerkey1 == 0 || diceValue % winnerkey2 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }

    }

}
