package problems.prob6;
//50 ~ 100까지 숫자 중 5의 배수를 출력해보세요.

public class Problem6 {
    public static void main(String[] args) {
        final int START =50;
        final int END =100;
        for(int i = START; i<=END; i++){
            if(i %5 == 0){
                System.out.println(i);
            }
        }

    }
}
