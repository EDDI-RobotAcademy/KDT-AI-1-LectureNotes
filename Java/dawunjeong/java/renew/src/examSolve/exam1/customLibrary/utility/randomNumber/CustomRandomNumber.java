package examSolve.exam1.customLibrary.utility.randomNumber;

public class CustomRandomNumber {
    public static int generateRandomNumber(int MIN, int MAX){
        return (int) (Math.random() * (MAX - MIN + 1)) + MIN;
    }
}
