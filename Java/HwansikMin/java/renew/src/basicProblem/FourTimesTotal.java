package basicProblem;

public class FourTimesTotal {
    public static void main(String[] args) {

        int fourtimessum = 0;
        for(int i = 1; i<=100; i++) {
            if(i % 4 == 0) {
                fourtimessum += i;
            }
        }
        System.out.println(fourtimessum);
    }
}
