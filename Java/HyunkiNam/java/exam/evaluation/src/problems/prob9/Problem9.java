package problems.prob9;

import customLibrary.CustomRandom;

public class Problem9 {
    public static void main(String[] args) {
        StringBuilder emailSb = new StringBuilder();
        int EMAIL_LENGTH = 5;

        for(int i=0; i<EMAIL_LENGTH; i++){
            emailSb.append((char) CustomRandom.generateNumber('a', 'z'));
        }

        System.out.println(emailSb + "@test.com");
    }
}
