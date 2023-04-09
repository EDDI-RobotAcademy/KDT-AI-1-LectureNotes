package problems.prob15;

import customLibrary.utility.sequence.NumberSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15 {
    public static void main(String[] args) {
        Integer[] initArr = { 1, 3 };
        List<Integer> numberList = new ArrayList<>(Arrays.stream(initArr).toList());
        NumberSequence sequence = new NumberSequence(numberList);

        final int WANT_TO_FIND_IDX = 273;
        final int findValue = sequence.applyProb15Rules(WANT_TO_FIND_IDX);
        System.out.printf("%d번째 항은 %d", WANT_TO_FIND_IDX, findValue);
    }
}
