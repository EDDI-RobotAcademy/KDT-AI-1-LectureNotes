package problems.prob9;

import java.util.ArrayList;
import java.util.List;
import customLibrary.CustomRandom;

public class Problem9 {
    public static void main (String[] args) {
        // 영어 소문자 3자리와 숫자 4자리로 조합
        final int START = 1;
        final int END = 7;
        final int ENG_MIN = 97;
        final int ENG_MAX = 122;
        final int NUMBER_MIN = 0;
        final int NUMBER_MAX = 9;

        List<String> list = new ArrayList<String>();

        for (int i = START; i <= END; i++) {
            if (i <= 3) {
                list.add(String.valueOf((char) CustomRandom.generateNumber(ENG_MIN, ENG_MAX)));
            } else {
                list.add(String.valueOf(CustomRandom.generateNumber(NUMBER_MIN, NUMBER_MAX)));
            }
        }
        list.add("@test.com");

        String email = String.join("", list);

        System.out.println("이메일 : " + email);
    }
}
