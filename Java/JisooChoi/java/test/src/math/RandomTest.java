package math;

public class RandomTest {
    public static void main(String[] args) {
        final int START = 0;
        final int END = 100;
        final int TEST_MIX = 77;
        final int MAX = 15;
        final int MIN = 5;
//        랜덤으로 만드는 방법
//        1. Math.random()을 작성한다.
//        2. 최소값과 최대값을 확인한다.
//        3. 최소값은 더하기로 표기해주기 (아래 코드에서는 +1)
//        4. 최대 값은 곱하기로 표기하고
//           실제 최대값 계산은 곱하기하는 값 + 최소 값 -1 이다.
//           (아래에선 100 +1 -1로 100에 해당한다.)
//           그러므로 1 ~ 100까지의 숫자를 출력하게 된다.
        final int randomNumber = (int)(Math.random() * 100) +1;

        System.out.println("randomNumber = " +randomNumber);

        int randomValue = 0;
        int count = 0;

        for(int i = START;  i< END; i++){
            randomValue = (int)(Math.random() * TEST_MIX) +1;
            System.out.println("i = " + i + ", randomValue = "+randomValue);
        }

        System.out.println();

        // 5 ~ 15 표현
        for(int i = START; i <END; i++){
            randomValue = (int)(Math.random() * (MAX - MIN +1)) + MIN; // 5 ~ 15
            System.out.println("i = "+ i + ", randomValue = "+randomValue);
        }
    }
}
