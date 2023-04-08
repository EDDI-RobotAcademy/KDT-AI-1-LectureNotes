package problems.prob4;

public class Problem4 {
    public static void main(String[] args) {
        int sum = 0;
        final int MIN = 54;
        final int MAX = 132;

        for(int i=MIN; i<=MAX; i++){
            sum += i;
        }

        System.out.println(sum);
    }
}
