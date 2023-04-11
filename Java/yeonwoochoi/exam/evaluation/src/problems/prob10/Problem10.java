package problems.prob10;

// 50 ~ 100까지 숫자를 모두 합산한 결과를 출력하세요.
public class Problem10 {
    public static void main(String[] args) {

        int sum = 0;
        for (int i = 50; i <= 100; i++) {
            sum = sum + i ;
        }
        System.out.println(sum);

    }
}
