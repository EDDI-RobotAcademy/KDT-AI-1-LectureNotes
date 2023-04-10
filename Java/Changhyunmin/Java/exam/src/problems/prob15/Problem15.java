package problems.prob15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15 {
    public static void main(String[] args) {//15PASS
        //1, 3, 5, 7, 9, 11, 13, …
        //이 수열의 273번째 값을 프로그램으로 작성하여 구해보세요.
        int One = 1;
        int EVEN = 2;
        int[]num = new int[273];
        List<Integer> numList = new ArrayList<>();


        for (int i = One; i < num.length; i+= EVEN){
            numList.add(num.length);
            System.out.println(i);
        }
    }
}
