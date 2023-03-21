package math;

public class Dice {
    public static void main(String[] args) {
        int round = 2;
        final int DICE = 2;
        for (int i = 0; i < round; i++){
            int result = 0;
            for (int j = 0; j < DICE; j++) {
                int diceNumber = (int) (Math.random() * 6) + 1;
                result += diceNumber;
            }
            System.out.println(i + 1 + "라운드 결과: 주사위 " + DICE + "개의 합 = " + result);
            if (result % 4 == 0) {
                System.out.println("승리");
            }
            else {
                System.out.println("패배");
            }
        }
    }
}
