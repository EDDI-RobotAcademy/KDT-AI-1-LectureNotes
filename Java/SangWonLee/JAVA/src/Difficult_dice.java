import java.util.Arrays;

class Dice {
    final int START = 0; // 시작 숫자
    final int dice_MAX = 6; // 주사위 6까지
    final int dice_MIN = 0; // 주사위 0부터
    final int dice_number = 3; //주사위의 갯수
    int dice1[] = new int[dice_number]; // 첫번째 사람의 주사위 배열
    int dice2[] = new int[dice_number];; // 두번째 사람의 주사위 배열
    int sum_dice1; // 첫번째 사람의 주사위 합
    int sum_dice2; // 두번째 사람의 주사위 합
    int all_dice[]; // 첫번째, 두번째 사람의 주사위 합의 배열

    public int[] roll_dice( ) {

        for (int i = START; i < dice_number; i++) {
            dice1[i] = (int) (Math.random() * (dice_MAX - dice_MIN + 1) + dice_MIN);
            if (dice1[0] % 2 == 0) {
                sum_dice1 = dice1[0];
                System.out.println(sum_dice1);
            } else {
                for (int j = START; j < dice_number; j++) {
                    sum_dice1 += dice1[j];
                    System.out.println(sum_dice1);
                }
            }
        }
        for (int i = START; i < dice_number; i++) {
            dice2[i] = (int) (Math.random() * (dice_MAX - dice_MIN + 1) + dice_MIN);
            if (dice2[0] % 2 == 0) {
                sum_dice2 = dice2[0];
                System.out.println(sum_dice2);
            } else {
                for (int j = START; j < dice_number; j++) {
                    sum_dice2 += dice2[j];
                    System.out.println(sum_dice2);
                }
            }
        }

        all_dice = new int[]{sum_dice1, sum_dice2};

        return all_dice;
    }


}


    public class Difficult_dice {
        public static void main(String[] args) {

            Dice d = new Dice();
            d.roll_dice();

        }
    }



