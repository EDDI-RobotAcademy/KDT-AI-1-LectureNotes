package problems.prob9;

import customLibrary.CustomLibrary;

import java.util.List;

// 랜덤한 이메일 주소를 만들어봅시다. 뒤에는 @test.com 을 붙여주세요.
public class Problem9 {
    public static void main(String[] args) {

        int RANDOM_MAIL = 5;
        int MIN_EMAIL = 4;
        int MAX_EMAIL = 8;


        for (int i = 0; i < RANDOM_MAIL; i++) {
            String tmpString = "";
            int emailLength = CustomLibrary.generateNumber(MIN_EMAIL, MAX_EMAIL);

            for (int j = 0; j < emailLength; j++) {
                tmpString += (char) CustomLibrary.generateNumber('a', 'z');

                System.out.println(tmpString + "@test.com");
            }
        }
    }
}