package problems.prob6;

// 50 ~ 100 까지 숫자 중 5의 배수를 출력해보세요
public class Five {

    final private int MIN = 50;
    final private int MAX = 100;

    public Five() {
        for (int i = MIN; i <= MAX; i++) {
            if (i % 5 == 0) {
                System.out.println(i);
            }
        }
    }
}
