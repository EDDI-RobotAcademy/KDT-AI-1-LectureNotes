package basic;

//1. 1 ~ 100까지 숫자중 짝수만 출력해보자.

public class Basic1 {
    static final int MIN = 1;
    static final int MAX = 100;
    static final int checkCount = 2;

    public static void main(String[] args) {
        for( int i = MIN; i<= MAX; i++){
            if(i % checkCount ==0){
                System.out.println(i);
            }
        }
    }

}
