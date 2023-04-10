package basicTest;

public class NumberTest2 {
    public static void main(String[] args) {
        final int MAX = 100;
        final int THREE_NUM = 3;

        for (int i = 1; i < MAX; i++) {
            if (i % THREE_NUM == 0) {
                System.out.println(i);
            }
        }
    }
}
