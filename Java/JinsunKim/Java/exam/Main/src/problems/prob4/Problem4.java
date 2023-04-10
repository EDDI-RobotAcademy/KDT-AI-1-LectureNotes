package problems.prob4;


public class Problem4 {
    public static void main(String[] args) {

        //54 ~ 132까지 더하는 프로그램을 만들어봅시다.

        int START = 54;
        final int END = 132;

        int sum = 0;
        // 반복문
        for (int i = START; i <= END; i++) {
                sum += START;
        }
        System.out.println("54부터 132까지 합: "+ sum);
    }
}
