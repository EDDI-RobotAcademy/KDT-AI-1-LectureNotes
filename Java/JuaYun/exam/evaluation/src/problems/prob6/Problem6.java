package problems.prob6;

public class Problem6 {
    public static void main(String[] args) {

        final int MIN = 50;
        final int MAX = 100;
        int KEY = 5;

        for (int i = MIN; i <= MAX; i++) {
            if (i % KEY == 0) {
                System.out.println(i);
            }
        }
    }
}
