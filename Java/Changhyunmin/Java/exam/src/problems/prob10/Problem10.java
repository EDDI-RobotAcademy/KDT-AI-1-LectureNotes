package problems.prob10;

public class Problem10 {
    public static void main(String[] args) {
        //10. 50 ~ 100까지 숫자를 모두 합산한 결과를 출력하세요.
        final int START = 50;
        final int END = 100;
        int Sum = 0;
        for (int i = START; i <= END; i++){
            Sum += i;

        }
        System.out.println(Sum);
    }
}
