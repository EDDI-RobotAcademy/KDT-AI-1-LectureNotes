package array;

public class StackArrayTest {
    public static void main(String[] args) {
        final int START = 0;

        final int[] numberArray = { 1, 2, 3, 4, 5 };


        for (int i = START; i < numberArray.length; i++) {

            System.out.println("배열출력: " + numberArray[i]);
        }
        System.out.println();


        for (int num: numberArray) {
            System.out.println("배열 원소 출력: " + num);
        }


    }
}
