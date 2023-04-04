package zproblem;

public class ThreeMultiple {
    int multiple = 3;

    public void printThreeMultiple() {
        for (int a = 1; a < 101; a++) {
            if (a % multiple == 0) {
                System.out.println(a);
            }
        }
    }

    public static void main(String[] args) {
        ThreeMultiple three = new ThreeMultiple();
        three.printThreeMultiple();
    }

}
