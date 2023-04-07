package problems.prob15;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Problem15 {
        public static void main(String[] args) {
            int[] A =new int[300];
            A[0]=1;
            for(int i =1; i < A.length;i++){
                A[i] = i+2;}
            System.out.println(Arrays.toString(A));
            System.out.println(A[272]); //273번째 값

    }
}
