package problems.prob4.prob4change;

import customLibrary.utility.sequence.NumberSequence;

public class Problem4Change {
    //utility 활용해서 문제풀기
    public static void main(String[] args) {


        final int START = 54;
        final int END = 132;

        final NumberSequence sequence = new NumberSequence(START, END);
        sequence.addThroughout();

        System.out.println(sequence.getTotalSum());
    }
}
