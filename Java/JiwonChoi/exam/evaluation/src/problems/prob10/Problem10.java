package problems.prob10;
/*
10. 50 ~ 100까지 숫자를 모두 합산한 결과를 출력하세요.
 */

public class Problem10 {
    public static void main(String[] args) {
        final int START_NUM = 50;
        final int END_NUM = 100;

        int sum = 0;
        for(int i = START_NUM; i <= END_NUM; i++) {
            sum += i;
        }

        System.out.println(sum);


    }
}
