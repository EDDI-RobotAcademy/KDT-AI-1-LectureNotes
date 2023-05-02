package problems.prob5;

import customLibrary.utility.sequence.NumberSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static void main(String[] args) {
        final Integer[] initArr = { 3, 3, 3 };
        final List<Integer> numberList = new ArrayList<>(Arrays.stream(initArr).toList());
        final NumberSequence sequence = new NumberSequence(numberList);

        final int findValue = sequence.applyProb5Rules(20);
        System.out.println("20번째 항은 " + findValue);
    }
}
