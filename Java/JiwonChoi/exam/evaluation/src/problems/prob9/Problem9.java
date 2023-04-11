package problems.prob9;

import customLibrary.Random;

import java.util.ArrayList;

/*
9. 랜덤한 이메일 주소를 만들어봅시다. 뒤에는 @test.com 을 붙여주세요.
*/
public class Problem9 {
    final int emailLengthMin = 4;
    final int emailLengthMax = 9;

    public void generateRandomEmail(){
        int randomEmailLength = Random.randomNumber(emailLengthMin, emailLengthMax);

        String email = "";
        for(int i = 0; i < randomEmailLength; i++ ){
            email += Random.randomAlphabetSmall();
        }
        System.out.printf("%s@test.com ",email);
    }

    public static void main(String[] args) {
        Problem9 problem9 = new Problem9();
        problem9.generateRandomEmail();
    }
}
