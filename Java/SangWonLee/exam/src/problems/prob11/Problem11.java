package problems.prob11;

public class Problem11 {
    public static void main(String[] args) {
        int END = 100;
        int SUM = 0;

        for (int i = 50; i <= END; i++){
            if ( i % 2 == 0) {
                SUM += i;

                System.out.println(i + " " + SUM);
            }
        }
        System.out.println("총 합 : " + SUM);

    }

}
