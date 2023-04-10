package problems.prob9;

import customLibrary.utility.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Problem9 {
    static List<String> emailList = new ArrayList<>();
    public static void emailMaker(int EMAIL_NUMBER) {
        final int MAX_LENGTH = 16;
        for (int i = 0; i < EMAIL_NUMBER; i++) {
            String tmpEmail = "";
            int emailLength = CustomRandom.generateNumber(MAX_LENGTH);
            for (int j = 0; j < emailLength; j++) {
                if (CustomRandom.generateNumber(1) == 0) {
                    tmpEmail += (char) CustomRandom.generateNumber('a', 'z');
                }
                else {
                    tmpEmail += CustomRandom.generateNumber(0, 9);
                }
            }
            emailList.add(tmpEmail + "@test.com");
        }
    }

    public static void main(String[] args) {
        final int EMAIL_NUMBER = 3;
        emailMaker(EMAIL_NUMBER);

        for (String email : emailList) {
            System.out.println(email);
        }
    }
}

// 9. 랜덤한 이메일 주소를 만들어봅시다. 뒤에는 @test.com 을 붙여주세요.