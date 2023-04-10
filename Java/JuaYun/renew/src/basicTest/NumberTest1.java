package basicTest;

public class NumberTest1 {
    public static void main(String[] args) {
        final int MAX = 100;
        final int NumberKey = 2;

        for (int i = 1; i <= MAX; i++) {
           if(i % NumberKey == 0) {
               System.out.println(i);
           }
        }
    }
}
