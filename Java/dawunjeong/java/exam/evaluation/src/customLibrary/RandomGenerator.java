package customLibrary;

public class RandomGenerator {
    final private static int MIN = 0;

    public static int generateNumber (int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static int generateNumber (int max) {
        return generateNumber(MIN, max);
    }

//    final int MIN;
//    final int MAX;
//    int randomNumber;
//
//    public RandomGenerator(int MIN, int MAX) {
//        this.MIN = MIN;
//        this.MAX = MAX;
//    }
//
//    public int getRandomNumber(){
//        randomNumber = (int)(Math.random()*(MAX - MIN + 1)) + MIN;
//        return randomNumber;
//    }
//
//    @Override
//    public String toString() {
//        return "RandomGenerator{" +
//                "randomNumber=" + randomNumber +
//                '}';
//    }
}
