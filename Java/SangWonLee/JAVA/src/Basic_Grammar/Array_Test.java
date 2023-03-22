package Basic_Grammar;

public class Array_Test {
    public static void main(String[] args) {
        final int START = 0;
        final  int[] numberArray = {1, 2, 3, 4, 5};

        // 배열의 경우 아래와 같이 numberArray.length 형태로 전체 길이를 파악할 수 있다.

        for (int i = START; i < numberArray.length; i++) {
            System.out.println(" 배열 출력 : " + numberArray[i]);
            /*
             배열 출력 : 1
             배열 출력 : 2
             배열 출력 : 3
             배열 출력 : 4
             배열 출력 : 5
             */
        }
        System.out.println();
        // for의 변형 버전 foreach라고도 함
        for (int num : numberArray){
            System.out.println("배열 원소 출력 : " + num);
        }
        /*
        배열 원소 출력 : 1
        배열 원소 출력 : 2
        배열 원소 출력 : 3
        배열 원소 출력 : 4
        배열 원소 출력 : 5
         */
    }
}
