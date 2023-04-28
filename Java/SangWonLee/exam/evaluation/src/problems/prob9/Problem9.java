package problems.prob9;

import customLibrary.utility.random.CustomRandom;

public class Problem9 {
    public static void main(String[] args) {
        final int START = 8;
        final int END = 12;

        String randomEmailAddress = "";
        final int emailLength = CustomRandom.generateNumber(START, END);
        for (int i = 0; i < emailLength; i++) {
            final char randomCharacter = (char) CustomRandom.generateNumber('a', 'z');
            randomEmailAddress += randomCharacter;
        }

        randomEmailAddress += "@test.com";
        System.out.println("생성된 이메일 주소: " + randomEmailAddress);
    }
}
