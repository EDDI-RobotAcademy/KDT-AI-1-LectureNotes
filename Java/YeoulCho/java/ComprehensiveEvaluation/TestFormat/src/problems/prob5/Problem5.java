package problems.prob5;

import java.util.Arrays;

//3, 3, 3, 6, 9, 12, 18, 27, 39, 57, … 이 숫자 나열의 20번째엔 어떤
//  0  0  3  3  3   6   9   12  18  27 39
public class Problem5 {
    public static void main(String[] args) {
        int[] A = new int[20];
        A[0] = 3;
        A[1] = 3;
        A[2] = 3;
        for (int i = 3; i < A.length; i++) {
            A[i] = A[i - 1] + A[i - 3];
        }
        System.out.println(Arrays.toString(A));
        System.out.println(A[19]);


    }
}
