package basicTest;

import java.sql.SQLOutput;
// 2의 배수
public class FirstProb1 {
    public static void main(String[] args) {
        final int MAX = 100;
        final int EVEN_DECISION = 2;
        final int EVEN = 0;

        for(int i = 0; i <= MAX; i++) {
            if (i % EVEN_DECISION == EVEN) {
                System.out.println("짝수만 출력: " + i);
            }
        }
    }
}
