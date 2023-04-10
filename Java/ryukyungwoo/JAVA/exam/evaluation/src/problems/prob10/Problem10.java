package problems.prob10;

class Sum {
    final private int MAX_NUMBER = 100;
    final private int MIN_NUMBER = 50;
    private int totalSum;

    public Sum () {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
                totalSum += i;
            }
        }

    public int getTotalSum() {
        return totalSum;
    }

    @Override
    public String toString() {
        return "Sum{" +
                "totalSum=" + totalSum +
                '}';
    }
}

public class Problem10 {
    public static void main(String[] args) {
        System.out.println(new Sum());

    }
}
