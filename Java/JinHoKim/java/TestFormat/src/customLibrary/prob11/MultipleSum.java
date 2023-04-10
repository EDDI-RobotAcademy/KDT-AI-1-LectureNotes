package customLibrary.prob11;

public class MultipleSum {
    final int MIN;
    final int MAX;
    final int MULTIPLE;

    public MultipleSum(int MIN, int MAX, int MULTIPLE) {
        this.MIN = MIN;
        this.MAX = MAX;
        this.MULTIPLE = MULTIPLE;
    }

    public void multipleSum() {
        int tmpSum = 0;
        for (int i = MIN; i <= MAX; i++) {
            if (i % MULTIPLE == 0) {
                tmpSum += i;
                System.out.println(MIN + " 부터"
                        + MAX + " 까지의 " +
                        MULTIPLE + " 의 배수: " +
                        i);
            }
        }
        System.out.println(MIN + " 부터"
                + MAX + " 까지의 " +
                MULTIPLE + " 의 배수 합: " +
                tmpSum);
    }
}
