package problems.prob15;

import customLibrary.utility.classProb15.Odd;

public class Problem15 {
    public static void main(String[] args) {
        final int TARGET = 273;
        Odd odd = new Odd(TARGET);
        System.out.println(odd.getResult());
    }
}

// 15. 아래와 같은 수열이 있습니다.
// 1, 3, 5, 7, 9, 11, 13, …
// 이 수열의 273번째 값을 프로그램으로 작성하여 구해보세요.