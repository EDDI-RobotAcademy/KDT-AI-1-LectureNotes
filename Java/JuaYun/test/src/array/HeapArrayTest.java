package array;

public class HeapArrayTest {
    public static void main(String[] args) {
        final int START = 0;
        final int ALLOC_ARRAY_NUMBER = 5;


        final int[] numberArray= new int[ALLOC_ARRAY_NUMBER];



        for (int i = START; i < ALLOC_ARRAY_NUMBER; i++) {
            numberArray[i] = i + 1;

            System.out.printf("numberArray[%d] = %d\n", i, numberArray[i]);
            //System.out.println("numberArray[" + i + "] = " + numberArray[i]);
        }

        System.out.println();

        for (final int num: numberArray) {
            System.out.println(("numberArray elem: " + num));
        }
    }
}
