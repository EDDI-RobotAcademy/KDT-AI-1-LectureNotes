package problems.prob9.prob9change;

import customLibrary.utility.random.CustomRandom;

public class Problem9Change {
    public static void main(String[] args) {//코드 수정

        final int start = 4;
        final int end = 8;
        String emaillAdress="";
        int emailLength = CustomRandom.generateNumber(start, end);
        for (int i = 0; i < emailLength; i++){
            final char randomCharacter = (char)CustomRandom.generateNumber('a','z');
            emaillAdress += randomCharacter;
        }
        System.out.println(emaillAdress + "@test.com");
    }
}
