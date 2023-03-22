package math;

public class Home {
    public static void main(String[] args) {

        final  int dice1 = (int) (Math.random() * 100) + 1;
        final  int dice2 = (int) (Math.random() * 100) + 1;
        int sum = dice1 + dice2;

        System.out.println("두 주사위의 합: " + sum);

        if (sum % 4 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }

    }
}
