package problems.prob9;

import customLibrary.customRandom.CustomRandom;

class RandomEmail {
    private String myRandomEmail;
    private int MAX_EMAIL_LENGTH = 10;
    private int MIN_EMAIL_LENGTH = 4;
    public RandomEmail () {
        myRandomEmail = "";
        int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);
        for (int i = 0; i < emailLength; i++) {
            myRandomEmail += (char) (CustomRandom.generateNumber('a', 'z'));
        }
    }

    public String getMyRandomEmail() {
        return myRandomEmail;
    }

    @Override
    public String toString() {
        return "RandomEmail{" +
                "myRandomEmail='" + myRandomEmail + "@test.com" + '\'' +
                '}';
    }
}
public class Problem9 {
    public static void main(String[] args) {
        System.out.println(new RandomEmail());

    }
}
