package homework;

public class March21 {
    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 6;
        int dice1 = (int)(Math.random() * 6) + 1;
        int dice2 = (int)(Math.random() * 6) + 1;

        System.out.println("첫 번째 주사위 결과 = " + dice1);
        System.out.println("두 번째 주사위 결과 = " + dice2);

        int result = dice1 + dice2;

        System.out.println("두 주사위의 합 = " + result);

        if (result % 4 == 0) {
            System.out.println("성공");
        }
        if (result % 4 != 0) {
            System.out.println("패배");
        }
    }
}
