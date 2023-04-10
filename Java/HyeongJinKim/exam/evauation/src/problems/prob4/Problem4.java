package problems.prob4;

import static customLibrary.utility.Sum.sumNumber;

public class Problem4 {

    public static void main(String[] args) {
        final int START = 54;
        final int END = 132;

        System.out.printf("%d부터 %d까지 정수의 합은 %d입니다.\n", START, END, sumNumber(START, END));
    }
}

// 4. 54 ~ 132까지 더하는 프로그램을 만들어봅시다.