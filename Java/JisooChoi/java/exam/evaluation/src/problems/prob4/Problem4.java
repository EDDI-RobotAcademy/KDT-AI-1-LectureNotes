package problems.prob4;

import customLibrary.prob4.PlusCalculator;

public class Problem4 {
    public static void main(String[] args) {
        // 4. 54 ~ 132 더하기
        PlusCalculator calculator = new PlusCalculator(54, 132);
        System.out.println("합계: "+calculator.addNum());
    }
}
