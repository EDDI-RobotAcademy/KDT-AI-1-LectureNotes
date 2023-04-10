package problems.prob11;

public class Problem11 {
    public static void main(String[] args) {
        //11. 50 ~ 100까지 2의 배수만 골라서 합산한 결과를 출력하세요.

        final int MIN = 50;
        final int MAX = 100;
        final int EVEN = 2;
        int sum = 0;

        for (int i = MIN ; i < MAX; i++) {
            if (i % EVEN ==0) {
                sum +=i;
            }
        }
        System.out.println("50~100까지의 2의 배수만 합산한 결과: " + sum);
    }
}
