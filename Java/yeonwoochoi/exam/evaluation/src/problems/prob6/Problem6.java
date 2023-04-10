package problems.prob6;

// 50 ~ 100까지 숫자 중 5의 배수를 출력해보세요.
public class Problem6 {
    public static void main(String[] args) {
        int MIN = 50;
        int MAX = 100;

        for (int i = MIN; i <= MAX; i++)
        {
            if (i % 5 == 0) {
                System.out.println(i);
            }

        }
    }

}
