package problems.prob4;

public class Problem4 {
    public static void main(String[] args) {
        final int MIN = 54;
        final int MAX = 132;

        int NumberSum = 0;

        for (int i = MIN; i <= MAX; i++){
            NumberSum += i;
        }
        System.out.println(NumberSum);
    }
}
