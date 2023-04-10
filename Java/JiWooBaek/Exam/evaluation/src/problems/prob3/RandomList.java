package problems.prob3;

// 3번 문제입니다.

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class RandomList {

    public static void main(String[] args) {
        char [] letters = new char[9];

        letters[0] = 'A';
        letters[1] = 'B';
        letters[2] = 'C';
        letters[3] = 'D';
        letters[4] = 'E';
        letters[5] = 'F';
        letters[6] = 'G';
        letters[7] = 'H';
        letters[8] = 'I';
        letters[9] = 'J';

        System.out.println("랜덤 문자: " + Arrays.toString(letters));

    }
}
