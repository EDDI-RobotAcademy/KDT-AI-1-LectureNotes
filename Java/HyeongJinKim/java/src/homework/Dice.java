package homework;

public class Dice {
    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 6;
        final int FOR_WIN = 4;

        final int ROUND = 2;
        final int DICE = 2;

        for (int i = 0; i < ROUND; i++){
            int result = 0;
            for (int j = 0; j < DICE; j++) {
                final int DICE_NUMBER = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
                result += DICE_NUMBER;
            }
            System.out.println(i + 1 + "라운드 결과: 주사위 " + DICE + "개의 합 = " + result);
            if (result % FOR_WIN == 0) {
                System.out.println("승리");
            }
            else {
                System.out.println("패배");
            }
        }
    }
}
