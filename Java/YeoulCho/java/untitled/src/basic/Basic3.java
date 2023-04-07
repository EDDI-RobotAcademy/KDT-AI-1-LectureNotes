package basic;
//1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자!
public class Basic3 {

    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 100;
        final int checkCount = 4;


        int NumberSum = 0;

        for (int i = MIN; i <= MAX; i++) {

            if (i % checkCount == 0) {
                NumberSum += i;
                System.out.println(i);
            }
        }
        System.out.println(NumberSum);
    }
}