package problems.prob7;

import problems.CustomRandom;

import java.sql.SQLOutput;

public class AppleClass {
    private int Apple = 2000;
    int MIN = 2000 + (int)(2000 * 0.2);
    int MAX = 2000 + (int)(2000 * 0.3);

    public AppleClass() {
        Apple = CustomRandom.generateNumber(MIN, MAX);
        System.out.println(Apple);
    }
}
