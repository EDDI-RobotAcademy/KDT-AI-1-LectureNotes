package homework9.gameSystem.utility;

public class CustomRandom {
    public static int generateNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    public static float generateFloatNumber() {
        return (float) Math.random();
    }
}
