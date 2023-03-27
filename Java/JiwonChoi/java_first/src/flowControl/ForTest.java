package flowControl;

public class ForTest {

    public  static void main(String[] args) {
        final int START = 3;
        final int END = 10;

        // for문을 만드는 방법
        // 1. for를 작성하고 소괄호()를 작성후 중괄호{}를 작성한다.
        // 2. 소괄호 내부는 아래와 같이 구성됩니다.
        //   (초기화; 조건; 증감)
        //   여기서 초기화란 for문을 최초로 만나는 순간에만 동작하게 됩니다.
        //   그러므로 없어도 된다.
        //   - 조건은 while, if, switch 등에서 봤던 조건식과 동일하다.
        //     조건을 만족하는 동안 for문이 반복된다.
        //   - 증감도 없어도 된다.
        //     표현을 조금 더 예쁘게 만들어주기 위해서 증감파트가 존재한다고 봐도 무방하다.
        // 3. 중괄호 내에는 for문을 반복하며 작업할 내용을 적는다.


        // 요한 것은 어찌되었든 for문은
        // 조건 파트가 참인 동안은 언제든지 반복된다는 것이다.
        // 초기화나 증감파트는 곁다리에 불과하다.

        for (int idx = START; idx < END; idx++) {
            System.out.println("idx = " + idx);
        }

        /*
         for (int index = START; idx < END; index++) {
             System.out.println("index = " + index);
         }
         */

        //루프를 돌면서 덧셈을 하려면 반드시 아래와 같이
        //외부에 0으로 초기화된 변수를 가지고 누산해야 합니다.
        int sum = 0;
        int count = 0;

        for (int idx = START; idx <= END; idx++) {
            sum = sum + idx;
            // sum += idx; 는 위와 같은 뜻이다.
            // sum은 sum + idx라는데 왜 값이 누산되는 것일까?
            // '=' 연산자는 '~과 같다'가 아니다.
            // '=' 연산자는 대입 연산자이다.
            // 오른쪽에 있는 정보를 왼쪽에 대입한다.  <-
            System.out.println("count =" + (++count) + ", sum = " + sum);
        }

        System.out.println("3 ~ 10까지의 합: " + sum);

        // 조건이 없으므로 무조건이다.
//        for (;;) {
//            System.out.println("무한 반복");
//        }

        for (int i = START; i <= END; i++) {
            // '%' 연산자는 나머지 연산자이다.
            // (mod 2)와 동의어이며 이건 몰라도 된다.

            // 현재 i값을 2로 나눈 나머지가 0이냐를 묻는 것이다.
            // 2로 나눈 나머지가 0이란 것은 짝수임을 의미한다.
            // 고로 이 로직은 3~10사이의 홀수만 출력한다.
            if (1 % 2 == 0) { continue; }
            // continue는 skip과 동일하다.
            // continue에 걸리면 다시 첫줄의 i++로 넘어간다.

            System.out.println("i = " + i);
        }

        //whlie은 단순반복에, for는 조건반복에 주로 쓰인다.

    }





    //
}
