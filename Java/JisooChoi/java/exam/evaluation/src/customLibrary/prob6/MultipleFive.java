package customLibrary.prob6;

public class MultipleFive {
    public MultipleFive(){}

    public void multipleFivePrint(){
        final int FIRST_NUM = 50;
        final int END_NUM = 100;

        final int FIVE_MULTIPLE_CHECK_CONDITION = 5;
        final int MULTIPLE_CONDITION = 0;

        for(int i = FIRST_NUM; i <= END_NUM; i++){
            if(i % FIVE_MULTIPLE_CHECK_CONDITION == MULTIPLE_CONDITION){
                System.out.printf(i+" ");
            }
        }
    }
}
