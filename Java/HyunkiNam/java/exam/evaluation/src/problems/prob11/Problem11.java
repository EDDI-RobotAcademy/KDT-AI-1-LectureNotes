package problems.prob11;

public class Problem11 {
    public static void main(String[] args) {
        final int MIN_NUMBER = 50;
        final int MAX_NUMBER = 100;
        final int EVEN_CHECK = 2;
        int sum = 0;

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            if(i % EVEN_CHECK == 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
