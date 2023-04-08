package problems.prob6;

import customLibrary.NumberSequence;

import java.util.List;

public class Problem6 {
    public static void main(String[] args) {

        final int START = 50;
        final int END = 100;
        final int EVEN = 5;

        NumberSequence numberSequence = new NumberSequence(START, END);

        final List<Integer> foundNumberSequenc = numberSequence.findCounditionMatcNumber(EVEN);

        System.out.println("5의 배수: " + foundNumberSequenc);




    }
}
