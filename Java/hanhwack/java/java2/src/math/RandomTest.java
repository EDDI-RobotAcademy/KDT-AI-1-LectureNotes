package math;

public class RandomTest {
    public static void main(String[] args) {
        final int START = 0;
        final int END = 100;
        final int TEST_MAX = 77;
        final int MAX = 15;
        final int MIN = 5;
        final int randomNumber = (int)(Math.random() * 100) + 1;
        //랜덤을 만드는 방법
        //1.MAth.random()을 작성합니다.
        //2.최소값과 최대값을 확인합니다.
        //3.최소값은 더하기로 표기해주세요(아래 코드에선 + 1)
        //4.최대값은 곱하기로 표기하고
        //  실제 최대값 계산은 곱하기 하는 값 + 최소값 -1 입니다
        //  (아래에선 100 +1 -1로 100에 해당함)
        //  그러므로 1 ~ 100까지의 숫자를 만듭니다

        System.out.println("randomNumber = " + randomNumber);

        int randomValue = 0;
        int count = 0;

        for (int i = START; i < 100; i++) {
            randomValue = (int)(Math.random() * TEST_MAX) + 1; // 1 ~ 77
            System.out.println("i = " + i + ", randomValue = " + randomValue);
        }

        //5~15 vygus
        for (int i = START; i < END; i++) {
            randomValue = (int)(Math.random() * (MAX - MIN + 1)) + MIN; //5 ~ 15
            System.out.println("i = " + i + ", randomValue = " + randomValue);
        }
    }
}
