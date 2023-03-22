package flowControl;

import java.security.Key;
import java.util.Random;

public class DiceTest2 {

    public static void main(String[] args) {
        
        final int random1 = (int)(Math.random() * 6) + 1;
        final int random2 = (int)(Math.random() * 6) + 1;

        int A = random1;
        int B = random2;

        System.out.println("1번주사위 = " + A);
        System.out.println("1번주사위 = " + B);
        System.out.println(A + B);

        int C = A + B;

        if (C % 4 == 0) {
            System.out.println("승리하셨습니다!");
        }
        if (C % 4 != 0) {
            System.out.println("패배하셨습니다!");

        }
    }
}

