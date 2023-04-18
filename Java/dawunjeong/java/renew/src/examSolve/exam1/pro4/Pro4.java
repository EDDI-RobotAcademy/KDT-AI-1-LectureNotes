package examSolve.exam1.pro4;

import examSolve.exam1.customLibrary.number.NumberSequence;

// 문제 4번
// 54부터 132까지 더하는 프로그램
public class Pro4 {
    public static void main(String[] args) {
        NumberSequence pro4_numberSequence = new NumberSequence(54,132);
        System.out.println(pro4_numberSequence.sumNumber());
    }
}
