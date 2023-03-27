package Basic_Grammar;

public class HeapStackTest {
    public static void main(String[] args) {

        final int START = 0;
        final int ALLOC_ARRAY_NUMBER = 5;

        // Heap에 할당된 메모리 변경 금지를 요청한 것이고
        // 내부에 배치하는 것에는 영향을 받지 않기 때문임.
        final int[] numberArray = new int[ALLOC_ARRAY_NUMBER];

        for (int i = START; i < ALLOC_ARRAY_NUMBER; i++){
            numberArray[i] = i + 1;
            System.out.printf("number[%d] = %d\n", i, numberArray[i]);
        }
        System.out.println();
        for(int num : numberArray){
            System.out.println("numberArray elem : " +num);
        }
        /*
        number[0] = 1
        number[1] = 2
        number[2] = 3
        number[3] = 4
        number[4] = 5

        numberArray elem : 1
        numberArray elem : 2
        numberArray elem : 3
        numberArray elem : 4
        numberArray elem : 5
         */

    }
}
