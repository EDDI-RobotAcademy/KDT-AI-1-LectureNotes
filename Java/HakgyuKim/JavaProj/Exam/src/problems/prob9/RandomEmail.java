package problems.prob9;

import customLibrary.CustomRandom;

public class RandomEmail {
    final private String email;
    final private int emailLength = CustomRandom.generateNumber(4,8);
    public RandomEmail() {
        String tmpStr = "";
        for (int i = 0; i < emailLength; i++) {
            tmpStr += (char)CustomRandom.generateNumber('a','z');
        }
        email = tmpStr + "@test.com";
    }
    public void getRandomEmail() {
        System.out.println(email);
    }
}
