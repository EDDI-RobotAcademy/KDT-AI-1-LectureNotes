package problems.prob20;

import customLibrary.utility.random.CustomRandom;

public class Problem20 {
    public static void main(String[] args) {
        final int END = 10;
        for (int i = 0; i < END; i++) {
            System.out.println(CustomRandom.generateNumber(END));
        }
    }
}
