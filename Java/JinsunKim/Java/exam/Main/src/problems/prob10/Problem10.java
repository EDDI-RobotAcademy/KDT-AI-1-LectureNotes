package problems.prob10;

public class Problem10 {
    public static void main(String[] args) {

        //10. 50 ~ 100까지 숫자를 모두 합산한 결과를 출력하세요.

        final int MIN = 50;
        final int MAX = 100;


        int sum = 0;

        for (int i = MIN; i < MAX; i++) {
            sum += i;
        }
        System.out.println("50~100까지 합계: " + sum);



    }
}
