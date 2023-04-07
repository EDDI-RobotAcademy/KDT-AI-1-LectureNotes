package zzpractice;

public class FirstProb1 {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 100;
        final int EVEN_DECISION = 2;
        final int EVEN = 0;

        for (int i = START; i <= END; i++) {
            if (i % EVEN_DECISION == EVEN_DECISION) {
                System.out.println("짝수만 출력: " + i);
            }
        }
    }
}
