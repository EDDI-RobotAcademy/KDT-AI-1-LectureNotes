package javaProbs;

import java.util.ArrayList;
import java.util.List;

public class Prob1 {
    public static void main(String[] args) {
        final int RANGE = 100;
        int sum = 0;
        final List<Integer> list2 = new ArrayList<>();
        final List<Integer> list3 = new ArrayList<>();

        for (int i = 0; i <= RANGE; i++) {
            if (i % 2 == 0) {
                list2.add(i);
            }
            if (i % 3 == 0) {
                list3.add(i);
            }
            if (i % 4 == 0) {
                sum += i;
            }
        }
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(sum);
    }
}

/*아래 기본 문제들은 최소한으로 풀 수 있어야 하는 내용들입니다.
1. 1 ~ 100까지 숫자중 짝수만 출력해보자.
2. 1 ~ 100까지 숫자중 3의 배수만 출력해보자!
3. 1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자!
*/