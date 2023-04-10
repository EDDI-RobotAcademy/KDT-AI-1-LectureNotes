package problems.prob11;
/*
11. 50 ~ 100까지 2의 배수만 골라서 합산한 결과를 출력하세요.
 */

public class Problem11 {
    public static void main(String[] args) {

        final int START_NUM = 50;
        final int END_NUM = 100;
        final int DIVISION_NUM = 2;
        final int NO_REMAINDER = 0;

        int sum = 0;
        for(int i = START_NUM; i <= END_NUM; i++) {
            if (i % DIVISION_NUM == NO_REMAINDER) {
                System.out.print(sum);
                sum += i;
                System.out.println(" + " + i +" = " + sum);
            }
        }

    }
}
