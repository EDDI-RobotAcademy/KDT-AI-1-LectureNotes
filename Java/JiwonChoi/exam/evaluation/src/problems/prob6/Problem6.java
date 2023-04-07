package problems.prob6;
/*
6. 50 ~ 100까지 숫자 중 5의 배수를 출력해보세요.
*/
public class Problem6 {
    public static void main(String[] args) {
        final int START_NUM = 50;
        final int END_NUM = 100;
        final int DIVISION_NUM = 5;
        final int NO_REMAINDER = 0;

        for(int i = START_NUM; i <= END_NUM; i++) {
            if (i % DIVISION_NUM == NO_REMAINDER) {
                System.out.println(i);
            }
        }
    }
}
