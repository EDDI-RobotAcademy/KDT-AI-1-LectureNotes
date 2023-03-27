package homework;

public class Homework1 {
    public static void main(String[] args) {
        final int START = 0;
        final int END = 6;
        final int MAX = 6;
        final int MIN = 1;

        final int dice1 = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
        System.out.println("dice1 = " + dice1);
        final int dice2 = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
        System.out.println("dice2 = " + dice2);

        if ((dice1 + dice2) % 4 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}
