package problems.prob10;

// 10번 문제입니다.
public class Problem10 {
    public static void main(String[] args) {
            final int START = 50;
            final int END = 100;

            int sumNumber = 0;
            int count = 0;

            for(int i = START; i <= END; i++) {
                System.out.println("50 ~ 100까지의 총합: " + sumNumber);
                sumNumber += i;
            }
    }

}
