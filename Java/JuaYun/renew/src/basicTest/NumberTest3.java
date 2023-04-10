package basicTest;

public class NumberTest3 {
    public static void main(String[] args) {
        final int MAX = 100;
        final int EVEN_NUM2 = 4;
        int SumNumber = 0;

        for (int i = 1; i <= MAX; i++) {
            if (i % EVEN_NUM2 == 0)
                SumNumber += i;
        }
        System.out.println(SumNumber);
    }
}
