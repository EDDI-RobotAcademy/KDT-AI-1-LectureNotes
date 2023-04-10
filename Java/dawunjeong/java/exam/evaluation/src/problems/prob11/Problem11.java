package problems.prob11;

import customLibrary.RefactorMultipleNumber;
// 문제 11번
public class Problem11 {
    public static void main(String[] args) {
        int sum = 0;
        RefactorMultipleNumber multipleNumber2 = new RefactorMultipleNumber(50, 100, 2);
        for(int i = 0; i < multipleNumber2.getMultipleNumList().size(); i++){
            sum += multipleNumber2.getMultipleNumList().get(i);
        }
        System.out.println(multipleNumber2.getMultipleNumList());
        System.out.println(sum);
    }
}
