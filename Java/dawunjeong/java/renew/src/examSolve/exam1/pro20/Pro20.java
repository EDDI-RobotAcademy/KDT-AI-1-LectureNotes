package examSolve.exam1.pro20;

import examSolve.exam1.customLibrary.utility.randomNumber.CustomRandomNumber;

public class Pro20 {
    public static void main(String[] args) {
        final int randomValue = CustomRandomNumber.generateRandomNumber(1,200);
        System.out.println(randomValue);
    }
}
