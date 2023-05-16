package problems.prob5;

import java.util.ArrayList;
import java.util.Arrays;

// 3,3,3,6,9,12,18,27,39,57, ...
// 20번째엔 어떤 숫자가 있을지 프로그램을 작성해보세요
public class Problem5 {
    public static void main(String[] args) {
        int[] fibo = new int[20];
        fibo[0] = 3;
        fibo[1] = 3;
        fibo[2] = 3;
        fibo[3] = 6;

        for (int i = 4; i < fibo.length; i++) {
            fibo[i] = fibo[i - 3] + fibo[i - 1];
        }
        System.out.println(Arrays.toString(fibo));
        // 배열을 사용하는 방법을 잘 익혀야 할듯
    }
}
