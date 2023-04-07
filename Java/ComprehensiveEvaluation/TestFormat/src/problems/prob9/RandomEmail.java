package problems.prob9;

import customLibrary.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RandomEmail {
    private String emailId = "" ;
    final private int MIN_EMAIL_LENGTH = 5;
    final private int MAX_EMAIL_LENGTH = 8;
    private int emailLength;

    public RandomEmail() {
        emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);
        for (int i = 0; i < emailLength; i++) {
            emailId += (char)CustomRandom.generateNumber('a', 'z');
        }
    }

    public void getEmailId() {
        System.out.println(emailId + "@test.com");


    }
}
