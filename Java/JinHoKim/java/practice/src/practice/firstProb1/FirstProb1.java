package practice.firstProb1;

public class FirstProb1 {
    final int START = 1;
    final int END = 100;
    int NUM;
    int MULTIPLE;
    int MULTIPLESUMUM;

    public void printEven(String a, int NUM) {
        this.NUM = NUM;

        for (int i = START; i <= END; i++) {
            if (i % NUM == 0) {
                System.out.println(a + ": " + i);
            }
        }
    }

    public void printMultiple(String a, int MULTIPLE) {
        this.MULTIPLE = MULTIPLE;

        for (int i = START; i <= END; i++) {
            if (i % MULTIPLE == 0) {
                System.out.println(a + ": " + i);
            }
        }
    }

    public void printMultipleSum(String a, int MULTIPLESUMUM) {
        this.MULTIPLESUMUM = MULTIPLESUMUM;
        int multipleSum = 0;

        for (int i = START; i <= END; i++) {
            if (i % MULTIPLESUMUM == 0) {
                multipleSum += i;
            }
        }
        System.out.println(a + ": " + multipleSum);
    }

}


