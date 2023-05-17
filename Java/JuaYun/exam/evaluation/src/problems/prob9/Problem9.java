package problems.prob9;

import problems.CustomRandom;

// 랜덤한 이메일 주소를 만들어봅시다. 뒤에는 @test.com 을 붙여주세요
public class Problem9 {
    public static void main(String[] args) {
        String email = "";
        for (int i = 0; i < 5; i++) {
            email += (char) CustomRandom.generateNumber('a', 'z');
        }
        System.out.println(email + "@test.com");
    }
}