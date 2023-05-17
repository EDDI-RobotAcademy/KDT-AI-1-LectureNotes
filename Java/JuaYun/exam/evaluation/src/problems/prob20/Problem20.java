package problems.prob20;

import problems.CustomRandom;

// 랜덤한 숫자가 출력되도록 프로그램을 작성해주세요.
public class Problem20 {
    public static void main(String[] args) {
        int numberRandom = CustomRandom.generateNumber(0, 10);

        System.out.println(numberRandom);
    }
}
