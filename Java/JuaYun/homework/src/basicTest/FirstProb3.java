package basicTest;

import java.sql.SQLOutput;

// 4의 배수 출력후 합
public class FirstProb3 {
    public static void main(String[] args) {
        final int MAX = 100;
        final int FOUR_NUM = 4;
        final int NO_REMAIN = 0;

        int FOUR_SUM = 0;

        for(int i = 0; i <= MAX; i++) {
            if (i % FOUR_NUM == NO_REMAIN) {
                System.out.println("4의 배수만 출력: " + i);
                FOUR_SUM += i;
                System.out.println(FOUR_SUM);
            }
        }
    }
}
