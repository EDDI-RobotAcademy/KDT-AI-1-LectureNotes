package math;

public class DiceTest {
    public static void main(String[] args) {
        int randomDice1 = 0;
        int randomDice2 = 0;


        for (int i = 1; i < 100; i++) {
            randomDice1 = (int)(Math.random() * 6) + 1;
            randomDice2 = (int)(Math.random() * 6) + 1;
            int sum = randomDice1 + randomDice2;
            if (sum % 4 == 0) {
                System.out.println(i + "번째 시도에서 첫 번째 주사위 = " + randomDice1 +
                        ", 두 번째 주사위 = " + randomDice2 + ", 이며 둘의 합은 " +
                        sum + " 이고 합이 4의 배수이므로 승리하셨습니다.");
                break;
            }

            else {
                System.out.println(i + "번째 시도에서 첫 번째 주사위 = " + randomDice1 +
                        ", 두 번째 주사위 = " + randomDice2 + ", 이며 둘의 합은 " +
                        sum + " 이고 합이 4의 배수가 아니므로 패배하셨습니다.");
            }
        }
    }
}
