package customLibrary;

public class RefactorSumNumber {
    final private int start_number;
    final private int end_number;
    int sumNumber;

    public RefactorSumNumber(int start_number, int end_number) {
        this.start_number = start_number;
        this.end_number = end_number;
    }

    public int sumNumber(){
        for(int i = start_number; i <= end_number; i++){
            sumNumber += i;
        } return sumNumber;
    }
}
