package problems.prob3;

import customLibrary.CustomRandom;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {
        final int MIN = 0;
        final int MAX = 9;

        List<String> alphabetList = Arrays.asList(
                "A","B","C","D","E","F","G","H","I","J");

        System.out.println(alphabetList.get(CustomRandom.generateNumber(MIN,MAX)));
    }
}
