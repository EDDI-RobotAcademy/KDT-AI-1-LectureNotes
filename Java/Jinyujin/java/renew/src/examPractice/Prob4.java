package examPractice;

import utility.sequence.NumberSequence;

// 4. 54 ~ 132까지 더하는 프로그램을 만들어봅시다.
public class Prob4 {
    public static void main(String[] args) {
        final int START = 54;
        final int END = 132;

        final NumberSequence numberSequence = new NumberSequence(START, END);
        numberSequence.addThrougout();

//        System.out.println(numberSequence.getTotalSum);
    }
}
