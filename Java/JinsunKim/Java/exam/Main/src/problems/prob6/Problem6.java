package problems.prob6;

public class Problem6 {
    public static void main(String[] args) {

        //6. 50 ~ 100까지 숫자 중 5의 배수를 출력해보세요.
        final int START = 50;
        final int END = 100;
        final int FIFTH = 5;
        for (int i = START; i < END; i++) {
            if (i % FIFTH == 0) {
                System.out.println("5의 배수는 " + i + "입니다");
            }
        }
    }
}
