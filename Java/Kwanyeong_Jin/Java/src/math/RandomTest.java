package math;

public class RandomTest {
    public static void main(String[] args){
        final int START = 0;
        final int END = 100;
        final int MAX = 15;
        final int MIN = 5;
        final int randomNumber = (int)(Math.random() * 100) + 1;
//        랜덤 수 만는는 방법
//        1. Math.random()을 작성
//        2. 최소값과 최대값을 확인
//        3. 최소값은 더하기로 표기 (아래 코드에선 +1)
//        4. 최대갑은 곱하기로 표기
//           실제 최대값 계산은 곱하기하는 값 + 최소값 -1
//           아래에선 100 * 1 -1로 100에 해당
        System.out.println("randomNumber = " + randomNumber);

        int randomValue = 0;
//        for ( int i = START; i < END; i++) {
//            randomValue = (int)(Math.random() * MAX) + 1;
//            System.out.println("i = " + i + " randomValue =" + randomValue);
//            }

        for (int i = START; i < END; i++) {
            randomValue = (int)(Math.random() * (MAX - MIN + 1 )) + MIN; // 5~ 15
            System.out.println("i = " + i + " randomValue = " + randomValue);
        }
        }

    }

