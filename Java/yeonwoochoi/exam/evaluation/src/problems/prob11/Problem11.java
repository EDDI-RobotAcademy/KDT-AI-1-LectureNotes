package problems.prob11;
// 50 ~ 100까지 2의 배수만 골라서 합산한 결과를 출력하세요.

public class Problem11 {
    public static void main(String[] args) {
        int sum = 0;
        // 50 ~ 100 까지
        for (int i = 50; i <= 100; i++) {
            // 2의 배수만 출력
            if(i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("2의 배수 합: " + sum);

    }
}
