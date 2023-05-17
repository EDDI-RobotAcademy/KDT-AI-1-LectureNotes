package problems.prob11;

// 50 ~ 100 까지 2의 배수만 골라서 합산한 결과를 출력하세요
public class NumberSum3 {
    final private int MIN = 50;
    final private int MAX = 100;

    public NumberSum3() {
        int Sum = 0;
        for (int i = MIN; i <= MAX; i++) {
            if (i % 2 == 0) {
                Sum += i;
            }
        }
        System.out.println(Sum);
    }
}
