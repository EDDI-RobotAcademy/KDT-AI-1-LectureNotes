package basicProblem;

public class AppleNumber {
    public static void main(String[] args) {
        final int MAX = 5;
        final int MIN = 3;
        final int RandomAppleNumber
                = (int)(Math.random()*(MAX - MIN + 1)) + MIN;

        System.out.println("RandomAppleNumber = " + RandomAppleNumber);

    }
}
