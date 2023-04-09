package customLibrary;

public class MakeOddNumber {
    private int oddNum;

    public MakeOddNumber(int oddNum) {
        oddNum = 2*oddNum - 1;
        System.out.println(oddNum);
    }
}
