package problems.prob11;

// 11번 문제입니다.

import java.util.ArrayList;
import java.util.List;

public class NumberTest {

    public static void main(String[] args) {


        final int START = 50;
        final int END = 100;
        final int EVEN_DECISION = 2;
        final int NO_REMAIN = 0;

        int sumNumber = 0;
        int count = 0;

        for (int i = START; i <= END; i++) {
            if( i % EVEN_DECISION == NO_REMAIN) {
                System.out.println("2의 배수만 출력 : " + i);
                count += i;
                sumNumber += i;

            }
        }

        System.out.println("50 ~ 100까지 2의 배수들의 총합: " + sumNumber);


    }

}