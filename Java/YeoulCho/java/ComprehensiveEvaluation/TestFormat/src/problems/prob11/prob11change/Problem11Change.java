package problems.prob11.prob11change;

import customLibrary.utility.sequence.NumberSequence;

public class Problem11Change {
    public static void main(String[] args) {
        NumberSequence numberSequence = new NumberSequence(50,100);
        numberSequence.addThrounghoutCondition(2); //생성된 객체 내에서 2의 배수 찾는 메서드
        System.out.println(numberSequence.getTotalSum()); // 총합가져오는 메서드
    }
}
