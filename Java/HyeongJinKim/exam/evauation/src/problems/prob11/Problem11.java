package problems.prob11;

import customLibrary.utility.Multiple;
import customLibrary.utility.Sum;

public class Problem11 {
    public static void main(String[] args) {
        System.out.println(
                Sum.sumNumber(
                        Multiple.generateMultipleList(50, 100, 2)));
    }
}

// 11. 50 ~ 100까지 2의 배수만 골라서 합산한 결과를 출력하세요.