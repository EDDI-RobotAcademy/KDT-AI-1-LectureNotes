package homework.problem.first.classVersion.numberSequence;

import java.util.ArrayList;
import java.util.List;

public class NumberSequence {
    final int start;
    final int end;

    public NumberSequence(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public List<Integer> findConditionMatchNumber(int evenDecision){
        // 1 역할 : 리스트를 생성하고 (1 ~ 100까지 짝수인 수만 저장하는 리스트)
        // 2 역할 : 리스트를 생성하고 (1 ~ 100까지 3의 배수만 저장하는 리스트)
        List<Integer> tmpNumberList = new ArrayList<>();

        // 매개변수로 받아온 2(= 짝수 판별 조건)를 짝수 판별해 줄 때 사용함
        // 매개변수로 받아온 3(= 배수 판별 조건)를 짝수 판별해 줄 때 사용함
        for(int i = start; i <= end; i++){
            if(i % evenDecision == 0){
                tmpNumberList.add(i);
            }
        }
        return tmpNumberList;
    }


    public int findConditionAndSumNumber(int fourTimesDecision) {
        int tmpSum = 0;

        for(int i = start; i <= end; i++){
            if(i % fourTimesDecision == 0){
                tmpSum += i;
            }
        }
        return tmpSum;
    }
}
