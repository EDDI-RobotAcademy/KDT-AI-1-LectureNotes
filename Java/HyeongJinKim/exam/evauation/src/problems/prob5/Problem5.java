package problems.prob5;

public class Problem5 {
    public static int nextNumber (int n) {
        if (n < 3) {
            return 3;
        }
        else {
            return nextNumber(n - 3) + nextNumber(n - 1);
        }
    }

    public static void main(String[] args) {
        final int TARGET = 20;
        int result = 0;

        for (int i = 0; i < TARGET; i++) {
            result = nextNumber(i);
        }
        System.out.printf("%d번째 숫자는 %d입니다.\n",TARGET, result);
    }
}

// 5. 아래와 같은 숫자 나열이 있습니다. 3, 3, 3, 6, 9, 12, 18, 27, 39, 57, …
// 이 숫자 나열의 20번째엔 어떤 숫자가 있을지 프로그램을 작성해보세요.