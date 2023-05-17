package examSolve.exam1.pro6;

import examSolve.exam1.customLibrary.number.NumberSequence;
// 문제 6번
// 50부터 100까지 중 5의 배수 출력하기
public class Pro6 {
    public static void main(String[] args) {
        NumberSequence pro6_numberSequence = new NumberSequence(50,100);
        System.out.println(pro6_numberSequence.printMultipleNumberList(5));
    }
}
