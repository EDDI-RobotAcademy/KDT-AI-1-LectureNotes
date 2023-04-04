package zproblem;

public class Even {
    int even = 2;

    public void evenPrint() {
        for (int a = 1; a < 101; a++) {
            if (a % even == 0) {
                System.out.println(a);
            }
        }
    }

    public static void main(String[] args) {
        Even even = new Even();
        even.evenPrint();
    }

}
