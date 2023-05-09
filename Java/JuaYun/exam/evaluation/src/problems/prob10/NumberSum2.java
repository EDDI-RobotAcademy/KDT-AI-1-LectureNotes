package problems.prob10;

// 50~100까지 숫자를 모두 합산한 결과를 출력하세요
public class NumberSum2 {

    final private int MIN = 50;
    final private int MAX = 100;

    public NumberSum2() {
        int Sum = 0;
        for (int i = MIN; i <= MAX; i++) {
            Sum += i;
        }
        System.out.println(Sum);
    }
}
