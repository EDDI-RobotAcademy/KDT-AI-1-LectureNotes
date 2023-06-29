package kr.eddi.demo.lectureClass.utility.random;

public class CustomRandom {

    final private static int MIN = 0;
    public static int generateNumber (int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static int generateNumber (int max) {
        return generateNumber(MIN, max);
    }
}
