package problems.prob9;

import customLibrary.CustomRandom;

import java.util.Scanner;

public class Email {

    public void makeRandomEmail() {
        final int MIN_EMAIL_LENTH = 4;
        final int MAX_EMAIL_LENTH = 8;

        String tmpString = "";

        int emailLenth = CustomRandom.generateNumber(MIN_EMAIL_LENTH,MAX_EMAIL_LENTH);
        for (int i = 0; i < emailLenth; i++) {
            tmpString += (char) CustomRandom.generateNumber('a','z');
        }

        System.out.println(tmpString + "@test.com");
    }
}
