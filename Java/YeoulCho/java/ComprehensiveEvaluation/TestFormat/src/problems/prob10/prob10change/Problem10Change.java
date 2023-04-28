package problems.prob10.prob10change;

import customLibrary.utility.sequence.NumberSequence;

public class Problem10Change {
    public static void main(String[] args) {
        NumberSequence numberSequence = new NumberSequence(50,100);
        numberSequence.addThroughout(); // 앞선 문제에서 만든 메서드를 통해 합을 구함
        System.out.println(numberSequence.getTotalSum()); //총합가져오는 메서드 사용
    }
}
