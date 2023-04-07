package problems.prob6;

public class Problem6 {
    public static void main(String[] args) {
        final int START = 50;
        final int END = 100;
        final int DIVIDER = 5;
        for(int i=START; i <= END; i++) {
            if (i%DIVIDER==0){
                System.out.println(i);
            }
        }
    }
}
