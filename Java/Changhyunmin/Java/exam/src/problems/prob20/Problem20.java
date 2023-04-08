package problems.prob20;

import customLibrary.CustomRandom;

import java.util.Random;

public class Problem20 {
    public static void main(String[] args) {
        //20. 랜덤한 숫자가 출력되도록 프로그램을 작성해주세요.

        final int MIN = 1;
        final int MAX = 5000;
        int random = CustomRandom.generateNumber(MIN,MAX);
        System.out.println(random);
    }
}
