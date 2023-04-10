package customLibrary.prob10;

public class NumberSum {
    final private int MIN;
    final private int MAX;
    private int addNumResult;
    private int multipleAddNumResult;

    public NumberSum(int min, int max){
        this.MIN = min;
        this.MAX = max;
    }

    public void numberOfSum(){
        for(int i = MIN; i < MAX; i++){
            addNumResult += i;
        }
        System.out.println("50 ~ 100까지 숫자를 모두 합산한 결과: "+ addNumResult);
    }

    public void multipleNumOfSum(){
        final int SECOND_CONDITION = 2;
        final int SECOND_PERFECT_CONDITION = 0;

        for(int i = MIN; i < MAX; i++){
            if(i % SECOND_CONDITION == SECOND_PERFECT_CONDITION){
                multipleAddNumResult += i;
            }
        }
        System.out.println("50 ~ 100까지 2의 배수만 골라서 합산한 결과: "+
                multipleAddNumResult);
    }
}
