package flostControl;

public class ForTest {
    public static void main(String[] args) {
        final int START = 3;
        final int END = 10;

        // for 문을 만드는 방법
        // 1. for를 작성하고 소괄호를 작성후 중괄호를 작성한다.
        // 2. 소괄호 내부는 아래와 같이 구성됩니다.
        //    (초기화; 조건; 증감)
        //    - 여기서 초기화란 for문을 최초로 만나는 순간에만 동작하게 됩니다.
        //      그러므로 없어도 됩니다.
        //    - 조건은 while, if, switch 등에서 봤던 조건식과 동일합니다.
        //      조건을 만족하는 동안 for문이 반복됩니다.
        //    - 증감의 경우에도 없어도 됩니다.
        //      표현을 조금 더 예쁘게 만들어주기 위해 증감파트가 존재한다 봐도 무방합니다.
        // 3. 중괄호 내에는 for문을 반복하며 작업할 내용을 적어줍니다.

        //    중요한 것은 어찌되었든 for문은 조건 파트가 참인 동안은 언제든지 반복된다는 것입니다.
        //    초기화나 증감파트는 곁다리란 것이죠.
        for (int idx = START; idx < END; idx++) {
            System.out.println("idx = " + idx);
        }
        System.out.println("3부터 10까지 더하기");

        // 루프를 돌면서 덧셈을 하려면 반드시 아래와 같이
        // 외부에 0으로 초기화 된 변수를 가지고 누산해야 합니다.
        int sum = 0;
        int count = 0;

        for (int idx = START; idx < END; idx++) {
            sum += idx;
            // sum은 sum + idx라는데 왜 값이 누산이 되는 거야?
            // '=' 연산자는 '~과 같다'가 아닙니다
            // 오른쪽에 있는 정보를 왼쪽에 대입합니다.
            // '=' 연산자는 대입 assignment 연산자
            // sum = sum + idx;
            System.out.println(("count = " + (++count) + ", sum= " + sum));
        }
        System.out.println("3~9까지의 합: "+ sum);

//        for(;;) {
//            System.out.println("무한 반복");
//        }

        for (int i=START; i <= END; i++) {
            // '%' 연산자는 나머지 연산자입니다.
            // (mod 2)와 동의어이며 이건 몰라도 됩니다.

            // 현재 i값을 2로 나눈 나머지가 0이냐를 묻는 것이고
            // 2로 나눈 나머지가 0이란 것은 짝수임을 의미합니다.
            // 고로 이 로직은 3~10사이의 홀수만 출력합니다.

            if (i % 2==0) {
                continue;   //  continue는 skip과 동일합니다.
            }
            System.out.println("i= " + i);
        }
    }
}
