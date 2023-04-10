package problems.prob10;

public class Problem10 {
    public static void main(String[] args) {
        final int START = 50;
        final int END = 100;
        int Sum=0;
        for (int i = START; i <= END; i++) {
            Sum += i;
        }
        System.out.println(Sum);
    }
}
