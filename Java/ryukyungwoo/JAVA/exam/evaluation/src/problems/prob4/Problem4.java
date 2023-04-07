package problems.prob4;
class SumNumbers {
    final private int START = 54;
    final private int END = 132;
    private int totalSum;
    public SumNumbers () {
        for (int i = START; i <= END; i++) {
            totalSum += i;
        }
    }

    @Override
    public String toString() {
        return "SumNumbers{" +
                "totalSum=" + totalSum +
                '}';
    }
}

public class Problem4 {
    public static void main(String[] args) {
        SumNumbers sumNumbers = new SumNumbers();
        System.out.println(sumNumbers);

    }
}
