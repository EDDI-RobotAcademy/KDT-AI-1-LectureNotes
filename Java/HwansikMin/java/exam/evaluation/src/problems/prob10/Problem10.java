package problems.prob10;
//50 ~ 100까지 숫자를 모두 합산한 결과
public class Problem10 {
    public static void main(String[] args) {
        int START = 50;
        int END = 100;
        int SUM = 0;

        for (int i = START; i<=END; i++) {
            SUM += i;
        }
        System.out.println("50 ~ 100 합산 : " + SUM);
    }
}
