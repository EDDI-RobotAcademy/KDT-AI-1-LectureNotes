package math;

public class DiceExample {
    public static void main(String[] args) {
        final int DICE_MAX = 6;
        final int DICE_MIN = 1;
        final int ITER = 2;
        final int VICTORY_CONDITION = 4;

        int diceSum = 0;

        for (int i=0; i<ITER; i++) {
            final int dice = (int) (Math.random()*(DICE_MAX - DICE_MIN + 1)) + DICE_MIN;
            diceSum += dice;
            System.out.println((i+1) +"번째 주사위의 값: " + dice );
        }

        if (diceSum % VICTORY_CONDITION == 0) {
            System.out.println(ITER + "개의 주사위의 합이 " + diceSum + "(으)로 승리입니다.");
        } else {
            System.out.println(ITER + "개의 주사위의 합이 " + diceSum + "(으)로 패배입니다.");
        }

    }
}
