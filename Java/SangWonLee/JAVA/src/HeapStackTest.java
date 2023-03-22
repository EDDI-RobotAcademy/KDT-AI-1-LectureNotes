public class HeapStackTest {
    public static void main(String[] args) {

        final int START = 0;
        final int ALLOC_ARRAY_NUMBER = 5;
        final int[] numberArray = new int[5];

        for (int i = START; i < ALLOC_ARRAY_NUMBER; i++){
            numberArray[i] = i + 1;
            System.out.printf("number[%d] = %d\n", i, numberArray[i]);
        }
        System.out.println();
        for(int num : numberArray){
            System.out.println("numberArray elem : " +num);
        }

    }
}
