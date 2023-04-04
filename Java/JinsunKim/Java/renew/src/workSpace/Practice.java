package workSpace;

public class Practice {

    public static void main(String[] args) {

        final int MIN = 1;
        final int MAX = 100;
        final int EVEN = 2;
        final int MULTIPLE_THREE = 3;
        final int MULTIPLE_FOUR = 4;
        int SUM = 0;

        for (int i = MIN; i <= MAX; i++) {
            if ( !(i % EVEN == 0) ) {
                continue;
            }
            System.out.println("짝수 출력: " + i);
        }

        for (int i = MIN; i <= MAX; i++) {
            if (!(i % MULTIPLE_THREE == 0)) {
                continue;
            }
            System.out.println("3의 배수: " + i);

        }

        for (int i = MIN; i <=100; i++) {

            if (!(i % MULTIPLE_FOUR == 0)) {
                continue;
            }
            SUM += i;
        }
        System.out.println("4의 배수 합계: " + SUM);

    }

}
