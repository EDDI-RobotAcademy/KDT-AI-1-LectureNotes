package dice;

public class Dice {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 6;
        final int dice1 =  (int)(Math.random() * 6) + 1;
        final int dice2 =  (int)(Math.random() * 6) + 1;

        int sum = dice1 + dice2;

        System.out.println("dice1 = " + dice1);
        System.out.println("dice2 = " + dice2);
        System.out.println("두 주사위의 합은 " + sum + "입니다.");

        if(sum % 4 == 0) {
        System.out.println("승리입니다!");
        } else {
            System.out.println("패배입니다!");
        }

    }
}
