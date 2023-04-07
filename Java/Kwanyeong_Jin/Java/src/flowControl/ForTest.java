package flowControl;

public class ForTest {
    public static void  main(String[] args ){
        final int START = 3;
        final int END = 10;

//        for문 작성 방법
//        1. for를 작성하고 () 다음 {}
//        2. ()안에는 (초기화; 조건; 증감)
//        - 여기서 초기화란 for문을 최초로 만나는 순간에만 동작하게 되며 없어도 됨
//        - 조건은 while, if등과 같이 동일
//          조건이 만족하는 동안 for문이 반복
//        - 증감의 경우도 없어도 됨
//          표현을 조금 더 예쁘게 만들어주기 위해 증감파트가 존재
//        3. {}안에 for문을 반복하며 작업할 내용을 작성
        int sum = 0;
        int count = 0;
        for (int idx = START; idx <= END; idx++){
            sum += idx; // == sum = sum + idx;
            System.out.println("count = " + (++count) + " idx =" + idx + " sum =" + sum);
        // = 연산자는 오른쪽에 있는 정보를 왼쪽에 대입한다는 뜻(대입연산자)
        }
        int index = 0;
//        for (; index <= END;){
//            System.out.println("index= " + index++);
//        }
        System.out.println("3~ 10까지의 합: " + sum);
//        for(;;){
//            System.out.println(";; = 루프");
//        }
        // % 연산자는 나머지 연산자
        // i값을 2로 나눈 나머지가 0이냐고 묻는 것이고 나머지가 0이면 짝수
        // 이 로직은 홀수만 출력하는 로직
        for (int i = START; i <= END; i++) {
            if (i % 2 == 0) {continue;} // continue는 skip과 동일
            System.out.println("i = " + i);
        }

    }
}
