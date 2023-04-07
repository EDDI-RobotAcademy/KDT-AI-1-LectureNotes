package practice.bank2;

public class EvenNumber {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 101;
        final int EVEN_DECISION = 2;
        final int EVEN = 0;

        for (int i = START; i <END; i++) {
            if (i % EVEN_DECISION == EVEN) {
                System.out.println(i);
            }
        }
    }
}
