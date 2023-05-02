package basicTest;

// 3의 배수
public class FirstProb2 {
    public static void main(String[] args) {
        final int MAX = 100;
        final int THREE_NUM = 3;
        final int NO_REMAIN = 0;

        for(int i = 0; i <= MAX; i++) {
            if (i % THREE_NUM == NO_REMAIN) {
                System.out.println("3의 배수만 출력: " + i);
            }
        }
    }
}
