package problems.prob11;


class MultipleSum {
    final private int MAX_NUMBER = 100;
    final private int MIN_NUMBER = 50;
    final private int WANTED_MULTIPLE_NUMBER = 2;
    private int totalSum;

    public MultipleSum () {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            if (i % WANTED_MULTIPLE_NUMBER ==0) {
                totalSum += i;
            }
        }
    }

    public int getTotalSum() {
        return totalSum;
    }

    @Override
    public String toString() {
        return "MultipleSum{" +
                "totalSum=" + totalSum +
                '}';
    }
}





public class Problem11 {
    public static void main(String[] args) {
        System.out.println(new MultipleSum());
    }
}
