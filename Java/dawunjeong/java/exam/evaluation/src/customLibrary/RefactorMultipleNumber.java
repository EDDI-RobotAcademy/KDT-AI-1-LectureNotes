package customLibrary;

import java.util.ArrayList;
import java.util.List;

public class RefactorMultipleNumber {
    final private int MIN;
    final private int MAX;
    final private int multipleNum;
    final private List<Integer> multipleNumList = new ArrayList<>();

    public RefactorMultipleNumber(int MIN, int MAX, int multipleNum) {
        this.MIN = MIN;
        this.MAX = MAX;
        this.multipleNum = multipleNum;

        for(int i = MIN; i <= MAX; i++){
            if(i % multipleNum == 0){
                multipleNumList.add(i);
            }
        }
    }

    public List<Integer> getMultipleNumList() {
        return multipleNumList;
    }
}
