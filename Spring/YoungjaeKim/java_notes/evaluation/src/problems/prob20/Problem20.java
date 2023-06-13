package problems.prob20;

import java.util.Random;

public class Problem20 {
    public static void main (String[] args) {
        Random random = new Random();
        final int randomNumber = 100;
        int number = 0;

        number = random.nextInt(randomNumber);
        System.out.println("1 ~ 100 사이의 랜덤한 숫자 : " + number);
    }
}
