package customLibrary.utility;

import java.util.List;

public class Sum {
    static int sumResult = 0;
    public static int sumNumber (int start, int end) {
        for (int i = start; i <= end; i++) {
            sumResult += i;
        }
        return sumResult;
    }

    public static int sumNumber (int[] numberArr) {
        for (int number : numberArr) {
            sumResult += number;
        }
        return sumResult;
    }

    public static int sumNumber (List<Integer> numberList) {
        for (int number : numberList) {
            sumResult += number;
        }
        return sumResult;
    }
}
