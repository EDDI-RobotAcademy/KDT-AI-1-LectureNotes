package problems.prob11;
//50 ~ 100까지 2의 배수만 골라서 합산한 결과
public class Problem11 {
    public static void main(String[] args) {
        int START = 50;
        int END = 100;
        int SUM = 0;

        for (int i = START; i<=END; i++) {
            if(i % 2 == 0) {
                SUM += i;
            }
        }
        System.out.println("50 ~ 100에서 2의 배수 합산 : " + SUM);
    }
}
