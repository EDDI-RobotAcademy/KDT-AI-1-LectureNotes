package problems.prob5;

public class Problem5 {
    public static void main(String[] args) {
        final int MAX_SIZE = 20;
        int[] numberList = new int[MAX_SIZE];

        numberList[0] = 3;
        numberList[1] = 3;
        numberList[2] = 3;
        numberList[3] = 6;

        for(int i=4; i<MAX_SIZE; i++){
            numberList[i] = numberList[i-2] + numberList[i-3] + numberList[i-4];
        }

        System.out.println(numberList[MAX_SIZE-1]);
    }
}
