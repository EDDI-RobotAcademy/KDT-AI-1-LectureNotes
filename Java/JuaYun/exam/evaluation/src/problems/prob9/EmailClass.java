package problems.prob9;


import problems.CustomRandom;

public class EmailClass {
    final int MIN_EMAIL_LENGTH = 3;
    final int MAX_EMAIL_LENGTH = 5;
    String email;

    public EmailClass() {
        String tmpString = "";
        int email = CustomRandom.generateNumber(MIN_EMAIL_LENGTH,MAX_EMAIL_LENGTH);
        for (int i = 0; i < email; i++) {
            tmpString += (char) CustomRandom.generateNumber('a','z');
        }
        System.out.println(tmpString + "@test.com");
    }
}
