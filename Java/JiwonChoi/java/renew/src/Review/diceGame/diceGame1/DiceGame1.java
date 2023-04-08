package Review.diceGame.diceGame1;
/*
[주사위문제1]
주사위 2개를 만듭니다.
2개의 주사위를 굴려서 두 주사위의 합이 4의 배수가 된다면 승리
그 외의 케이스는 패배 처리하도록 만들어 봅시다!
*/

public class DiceGame1 {
    public static void main(String[] args) {
        final int DICE_COUNT = 2;

        final int DICE_NUMBER_MIN = 1;
        final int DICE_NUMBER_MAX = 6;

        int dicesNumberSum = 0;

        for (int i =0; i<DICE_COUNT; i++) {
            int DICE_NUMBER = ((int)(Math.random()* (DICE_NUMBER_MAX - DICE_NUMBER_MIN + 1)) + DICE_NUMBER_MIN);
            int DICE_INDEX = i + 1;
            System.out.printf("%d번째 주사위를 굴렸습니다. %d 나왔습니다.%n", DICE_INDEX, DICE_NUMBER );

            dicesNumberSum += DICE_NUMBER;
        }
        System.out.printf("주사위의 합은 %d입니다.%n", dicesNumberSum);

        final int WINNER_DECISION_NUM = 4;
        final int NO_REMAINDER = 0;

        if(dicesNumberSum % WINNER_DECISION_NUM == NO_REMAINDER){
            System.out.println("4의 배수입니다. 승리입니다.");
        } else {
            System.out.println("4의 배수가 아닙니다. 패배입니다.");
        }
    }
}
