package problems.prob6;

import customLibrary.RefactorMultipleNumber;

// 문제 6번
public class Problem6 {
    public static void main(String[] args) {
        RefactorMultipleNumber multipleNumber5 = new RefactorMultipleNumber(50, 100, 5);
        System.out.println(multipleNumber5.getMultipleNumList());
    }
}
