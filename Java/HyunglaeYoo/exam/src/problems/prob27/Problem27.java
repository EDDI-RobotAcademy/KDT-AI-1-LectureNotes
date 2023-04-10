package problems.prob27;

import customLibrary.CustomRandom;

public class Problem27 {
    public static void main(String[] args) {

        final int MIN = 1;
        final int MAX = 12;

        final int dice = CustomRandom.generateNumber(MIN, MAX);

        System.out.println(dice);



    }
}
