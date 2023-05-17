package examSolve.exam1.pro9;

import examSolve.exam1.customLibrary.utility.randomNumber.CustomRandomNumber;

// 문제 9번
// 랜덤한 이메일 만들기
// 뒤에는 @test.com
public class Pro9 {
    public static void main(String[] args) {
        final int emailLength;
        String emailAddress = "";
        emailLength = CustomRandomNumber.generateRandomNumber(8,12);
        for(int i = 0; i < emailLength; i++){
            final char email = (char) CustomRandomNumber.generateRandomNumber('a','z');
            emailAddress += email;
        }
        System.out.println(emailAddress + "@test.com");
    }
}
