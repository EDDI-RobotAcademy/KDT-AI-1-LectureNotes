package problems.prob15;

public class Problem15 {
    public static void main(String[] args) {
        final int N = 273;

        System.out.println(nthOddNumber(N));
    }

    public static  int nthOddNumber(int n) {
        return n * 2 -1;
    }
}
