package homework.fifth.review.strange;

public class StrangeTest {
    public static void main(String[] args) {
        final int START = 0;
        final int ALLOC_ARRAY_NUMBER = 5;

        final int[] numberArray = new int[ALLOC_ARRAY_NUMBER];

        for (int i = START; i < ALLOC_ARRAY_NUMBER; i++) {
            numberArray[i] = ++i; //<---- 요부분 입니다

            System.out.printf("numberArray[%d] = %d\n", i, numberArray[i]);
        }
    }
}
