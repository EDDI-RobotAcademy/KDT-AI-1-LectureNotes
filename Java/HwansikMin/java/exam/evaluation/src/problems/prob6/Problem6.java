package problems.prob6;
//50 ~ 100까지 숫자 중 5의 배수를 출력
public class Problem6 {
    public static void main(String[] args) {
        int START = 50;
        int END = 100;

        for (int i = START; i<=END; i++) {
            if(i % 5 == 0) {
                System.out.println("50 ~ 100에서 5의 배수 : " + i);
            }
        }
    }
}
