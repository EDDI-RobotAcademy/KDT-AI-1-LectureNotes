package problems.prob11;

public class Problem11 {
    public static void main(String[] args) {
        //11. 50 ~ 100까지 2의 배수만 골라서 합산한 결과를 출력하세요.
        final int START = 50;
        final int END = 100;
        final int EVEN = 2;
        int Sum = 0;
        for (int i = START; i <= END; i++){
            if (i % EVEN == 0){
                Sum += i;
            }
        }
        System.out.println(Sum);
    }
}
