package dice;

public class Dice {
    public static void main(String[] args) {

        // 1차 코딩
//        final int START = 1;
//        final int END = 6;
//        final int dice1 =  (int)(Math.random() * 6) + 1;
//        final int dice2 =  (int)(Math.random() * 6) + 1;
//
//        int sum = dice1 + dice2;
//
//        System.out.println("dice1 = " + dice1);
//        System.out.println("dice2 = " + dice2);
//        System.out.println("두 주사위의 합은 " + sum + "입니다.");

        final int MAX = 6;
        final int MIN = 1;
        final int ROLL_NUM = 2;
        final int multipleNumber = 4;

        int sum = 0;
        for(int i =1; i <= ROLL_NUM; i++){
            int dice =  (int)(Math.random() * MAX) + MIN;
            sum += dice;
            System.out.println(i + "번째 주사위의 수 : " + dice);
        }

        System.out.println("주사위의 합 : " + sum);

        if(sum % multipleNumber == 0) {
        System.out.println("승리입니다!");
        } else {
            System.out.println("패배입니다!");
        }

    }
}
