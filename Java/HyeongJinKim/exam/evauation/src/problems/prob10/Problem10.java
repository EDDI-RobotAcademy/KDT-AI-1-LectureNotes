package problems.prob10;

import static customLibrary.utility.Sum.sumNumber;

public class Problem10 {
    public static void main(String[] args) {
        final int START = 50;
        final int END = 100;

        System.out.printf("%d부터 %d까지 정수의 합은 %d입니다.\n", START, END, sumNumber(START, END));
    }
}

// 10. 50 ~ 100까지 숫자를 모두 합산한 결과를 출력하세요.