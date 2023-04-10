package customLibrary.prob10;

public class Total {
    final int MIN;
    final int MAX;

    public Total(int MIN, int MAX) {
        this.MIN = MIN;
        this.MAX = MAX;
    }

    public void sumPrint() {
        int tmpSum = 0;
        for (int i = MIN; i <= MAX; i++) {
            tmpSum += i;
        }
        System.out.println(MIN + " ~ " + MAX + " 까지의 합산은: " + tmpSum);
    }
}
