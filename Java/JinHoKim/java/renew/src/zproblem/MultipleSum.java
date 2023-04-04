package zproblem;

public class MultipleSum {
    int multiple = 4;

    public void printMultipleSum() {
        int sum = 0;

        for (int a = 1; a < 101; a++) {
            if (a % multiple == 0) {
                sum += a;
                System.out.println(sum);
            }
        }
    }

    public static void main(String[] args) {
        MultipleSum sumMultiple = new MultipleSum();
        sumMultiple.printMultipleSum();
    }
}
