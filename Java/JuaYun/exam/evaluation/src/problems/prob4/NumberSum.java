package problems.prob4;

// 54~132까지 더하는 프로그램을 만들어봅시다.
public class NumberSum {
    final private int MIN = 54;
    final private int MAX = 132;

    private int numSum = 0;

    public NumberSum() {
        for (int i = MIN; i <= MAX; i++) {
            numSum += i;
        }
        System.out.println(numSum);
    }
}
