package problems.prob5;

// 3, 3, 3, 6, 9, 12, 18, 27, 39, 57... 나열의 20번째 수 찾는 프로그램 작성
public class FindNumber {

    static int fib(int n) {
        if (n == 0) {
            return 3;
        }
        if (n == 3) {
            return 6;
        } else {
                return fib(n - 2) + fib(n - 1);
        }
    }

    public void find20() {
        for (int i = 0; i < 20; i++) {
            System.out.println(fib(i));
        }
    }
}
