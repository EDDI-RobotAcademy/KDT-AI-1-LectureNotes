package homework;

public class Homework1 {
    public static void main(String[] args) {

        final int MIN = 1;
        final int MAX = 6;

        final int Dice1 = (int) (Math.random() * MAX) + MIN;
        final int Dice2 = (int) (Math.random() * MAX) + MIN;

        System.out.println("첫 번째 주사위 결과 = " + Dice1);
        System.out.println("두 번째 주사위 결과 = " + Dice2);

        int result = Dice1 + Dice2;

        System.out.println("두 주사위의 합 = " + result);

        if (result % 4 == 0) {
            System.out.println("성공");
        }
        if (result % 4 != 0) {
            System.out.println("패배");
        }
    }
}
