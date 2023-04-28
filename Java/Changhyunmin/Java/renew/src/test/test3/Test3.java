package test.test3;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        int START = 1;
        int END = 100;
        int EVEN = 2;
        Number number = new Number(START, END);
        final List EvenNumber = number.QuestionNumberOne(EVEN);
        System.out.println(EvenNumber);

        int THREE = 3;
        final List ThreeNumber = number.ThreeDrainage(THREE);
        System.out.println(ThreeNumber);

        int FOUR = 4;
        final int FourNumber = number.FourDrainage(FOUR);
        System.out.println(FourNumber);
    }
}
