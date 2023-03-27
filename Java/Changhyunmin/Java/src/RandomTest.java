public class RandomTest {
    public static void main(String[] args) {
        final int START = 0;
        final int END = 100;
        final int MAX = 15;
        final int MIN = 5;
        //랜덤을 만든느 방법
        //1.Math.random()을 작성합니다.
        //2.최소값과 최대값을 확인합니다.
        //3.최소값은 더하기로 표기해주세요.(아래 코드에선 + 1)
        //4.최대값은 곱하기로 표기하고 실제 최대값 계산은 곱하기하는 값 + 최솟값 - 1입니다.
        //(아래에선 100 + 1 - 1 로 100에 해당함)
        //그로므로 1~100까지의 숫자를 만듭니다.
        final int randomNumber = (int)(Math.random() * 100) + 1;

        System.out.println("randomNumber = " + randomNumber);

        int randomValue = 0;

        for(int i = START; i < END; i++){
            randomValue = (int)(Math.random() * MAX) + 1;
            System.out.println("i = " + i + ",randomValue" + randomValue);
        }

        System.out.println();
        
        for(int i = START; i < END; i++) {
            randomValue = (int)(Math.random()*(MAX - MIN + 1)) +MIN;
            System.out.println("i = " + i + ",randomValue" + randomValue);
        }
    }
}
