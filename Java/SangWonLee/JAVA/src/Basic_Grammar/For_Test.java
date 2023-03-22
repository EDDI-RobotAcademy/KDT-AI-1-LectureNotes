package Basic_Grammar;

public class For_Test {
    public static void main(String[] args) {
        final int START = 3;
        final int END = 10;


//        for (int idx = START; index < END; idx++){
//            System.out.println("i = " + idx);
//        }

        System.out.println("3부터 10까지 더하기");

        int sum = 0;
        int count = 0;

        for (int idx = START; idx <= END; idx++) {
            sum += idx;
//          sum = sum + idx; 위에 꺼와 같은 뜻
            System.out.println("count = " + (++count + ", sum = " + sum));
        }
        System.out.println("3 ~ 10 까지의 합 : " + sum);
/*
        count = 1, sum = 3
        count = 2, sum = 7
        count = 3, sum = 12
        count = 4, sum = 18
        count = 5, sum = 25
        count = 6, sum = 33
        count = 7, sum = 42
        count = 8, sum = 52
        3 ~ 10 까지의 합 : 52
 */

//        for (;;){ // 조건이 없다는 뜻이라서 무한 반복된다.
//            System.out.println("무한 반복");
        for (int i = START; i <= END; i++) {
            if (i % 2 == 0) {
                continue; // continue 는 skip 과 동일합니다.
            }

            System.out.println("i = " + i);
            /*
            i = 3
            i = 5
            i = 7
            i = 9
            */
        }
    }
}
