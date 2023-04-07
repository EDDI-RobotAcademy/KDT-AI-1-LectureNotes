package practice.practice4;

public class UseEven {

    // 1. 1 ~ 100까지 숫자중 짝수만 출력해보자.
    final private int MIN_NUMBER = 1;
    final private int MAX_NUMBER = 100;
    final private int EVEN_DECISION = 2;

    public UseEven() {

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {

            if (i % EVEN_DECISION == 0) {
                System.out.println("짝수 > " + i);
            }
        }
    }
}
