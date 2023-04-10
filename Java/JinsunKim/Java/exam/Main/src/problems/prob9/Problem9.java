package problems.prob9;

import customLibrary.Dice;
import customLibrary.Random;

import java.util.ArrayList;
import java.util.List;

//랜덤한 이메일 주소를 만들어봅시다. 뒤에는 @test.com 을 붙여주세요.
 public class Problem9 {
    public static void main(String[] args) {

        int max = 97;
        int min = 122;
        int length = 6;

        for (int i = 0; i < length; i++ ) {
        int email = Random.generateNumber(122,97);
            System.out.print((char)email);
        }
        System.out.println("@test.com");
    }
 }

