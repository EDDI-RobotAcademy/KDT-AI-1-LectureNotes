package homework;

public class HomeWork {
    public static void main(String[] args) {
        final int diceA = (int)(Math.random() * 6) + 1;
        final int diceB = (int)(Math.random() * 6) + 1;


        System.out.println("diceA + diceB = " + (diceA + diceB));

        int diceSum = diceA + diceB;

        if (diceSum % 4 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}
