package math;

public class randomDice {
    public static void main(String[] args) {

        int sum = 0;
        final int MAX = 6;
        final int DICE_NUM = 2;  //주사위 갯수
        final int GOAL = 4; //승리조건 (배수)

        for(int i = 1; i <= DICE_NUM; i++) {
            final int randomValue = (int)(Math.random() * MAX) + 1; //1~6 중 하나의 수
            sum += randomValue;
        }

        System.out.println("주사위 " + DICE_NUM+" 개의 합은 " +sum);

        //승리 패배 판별
        if(sum % GOAL == 0) {
            System.out.println("승리!!!");
        } else {
            System.out.println("패배");
        }
    }

}
