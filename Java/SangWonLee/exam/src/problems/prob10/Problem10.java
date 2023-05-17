package problems.prob10;

public class Problem10 {
    public static void main(String[] args) {

        int END = 100;
        int SUM = 0;

        for (int i = 50; i <= END; i++){
            SUM += i;

            System.out.println(i + " " +SUM);

        }
        System.out.println("총 합 : " + SUM);

    }
}
