package problems.prob6;
class Multiple {
    final private int START = 50;
    final private int END = 100;
    final private int WANTED_MULTIPLE = 5;
    public Multiple () {
        for (int i = START; i <= END; i++) {
            if (i % WANTED_MULTIPLE == 0) {
                System.out.println(i);
            }
        }
    }

}

public class Problem6 {
    public static void main(String[] args) {
        System.out.println(new Multiple());
    }
}
