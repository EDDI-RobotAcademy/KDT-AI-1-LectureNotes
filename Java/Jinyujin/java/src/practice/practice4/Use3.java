package practice.practice4;

// 2. 1 ~ 100까지 숫자중 3의 배수만 출력해보자!
public class Use3 {
    final private int MIN_NUMBER = 1;
    final private int MAX_NUMBER = 100;
    final private int THREE_DECISION = 3;

    public Use3() {

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {

            if (i % THREE_DECISION == 0) {
                System.out.println("3의 배수 > " + i);
            }
        }
    }
}
