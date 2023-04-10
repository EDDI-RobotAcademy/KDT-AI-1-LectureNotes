package problems.prob10;

import customLibrary.RefactorSumNumber;

// 문제 10번
public class Problem10 {
    public static void main(String[] args) {
        RefactorSumNumber sumNumber = new RefactorSumNumber(50,100);
        System.out.println("총합: " + sumNumber.sumNumber());
    }
}
