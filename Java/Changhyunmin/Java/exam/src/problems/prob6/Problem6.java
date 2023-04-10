package problems.prob6;

public class Problem6 {
    public static void main(String[] args) {
        //6. 50 ~ 100까지 숫자 중 5의 배수를 출력해보세요.
        int MIN = 50;
        int MAX = 100;
        int DRAIN = 5;
        int END = 0;
        for (int i = MIN; i <= MAX; i++){
            if (i % DRAIN == END){
                System.out.println(i);
            }
        }
    }
}
