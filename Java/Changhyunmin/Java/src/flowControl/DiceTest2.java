package flowControl;
public class DiceTest2 {

    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 6;

        final int diceNumber1 = (int)(Math.random() * (MAX - MIN +1)) + MIN;
        final int diceNumber2 = (int)(Math.random() * (MAX - MIN +1)) + MIN;
        //1.diceNumber1, diceNumber2로 변경/A, B, C 제거

        final int diceSum = (diceNumber1 + diceNumber2);
        //2.final int diceSum 으로 변경

        final int GAME_WINNER_CHECK = 4;
        //3. 4대신 final int GAME_WINNER_CHECK 으로 사용

        System.out.println("첫번째 주사위 = " + diceNumber1);
        System.out.println("첫번째 주사위 = " + diceNumber1);
        System.out.println("두번째 주사위 = " + diceNumber2);
        System.out.println("두 주사위의 합 = " + diceSum);

        if (diceSum % GAME_WINNER_CHECK  == 0){
            System.out.println("승리하셨습니다!");
        }else{
            System.out.println("패배하셨습니다...");
        }
    }
}

