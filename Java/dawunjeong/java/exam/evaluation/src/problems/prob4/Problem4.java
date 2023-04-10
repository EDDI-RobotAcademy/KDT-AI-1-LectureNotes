package problems.prob4;

import customLibrary.RefactorSumNumber;

// 문제 4번
public class Problem4 {
    public static void main(String[] args) {
        RefactorSumNumber sumNumber = new RefactorSumNumber(54, 132);
        System.out.println("총합: " + sumNumber.sumNumber());
    }
}