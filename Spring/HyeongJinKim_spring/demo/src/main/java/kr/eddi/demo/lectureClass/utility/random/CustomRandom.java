package kr.eddi.demo.lectureClass.utility.random;

import java.util.ArrayList;
import java.util.List;

public class CustomRandom {

    final private static int MIN = 0;
    public static int generateNumber (int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static int generateNumber (int max) {
        return generateNumber(MIN, max);
    }

    public static List<Integer> generateNumberArr (int min, int max, int diceNumber) {
        List<Integer> diceArray = new ArrayList<>();
        for (int i = 0; i < diceNumber; i++ ) {
            diceArray.add(generateNumber(min, max));
        }
        return diceArray;
    }
}