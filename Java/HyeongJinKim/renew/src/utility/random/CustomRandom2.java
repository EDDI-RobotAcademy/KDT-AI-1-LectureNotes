package utility.random;

public class CustomRandom2 {
    final private static double MIN = 0;
    public static double generateNumber (double min, double max) {
        return ((Math.random() * (max - min + 1)) + min);
    }

    public static double generateNumber (double max) {
        return generateNumber(MIN, max);
    }
}