package problems.prob4;
//54 ~ 132까지 더하는 프로그램
public class Problem4 {
    public static void main(String[] args) {
        int START = 54;
        int END = 132;
        int SUM = 0;

        for (int i = START; i <= END; i++) {
            SUM += i;
        }
        System.out.println("최종합산 값 : " + SUM);
    }
}
