package homework;

public class HomeWork {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 6;


        final int Dice1 = (int)(Math.random() * END) + 1;
        final int Dice2 = (int)(Math.random() * END) + 1;
        int randomValue = 0;

        System.out.println("Dice1 + Dice2 = " + (Dice1 + Dice2));

        int SUM = Dice1 + Dice2;
        if (SUM % 4 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}
