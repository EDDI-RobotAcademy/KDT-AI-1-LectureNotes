package examSolve.exam1.customLibrary.number;

import java.util.ArrayList;
import java.util.List;

public class NumberSequence {

    private int start;
    private int end;
    private int sumNum;
    private List<Integer> numberList = new ArrayList<>();

    public NumberSequence(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public NumberSequence(List<Integer> numberList) {
        this.numberList = numberList;
    }

    // 1번 메소드
    // 원하는 두 숫자 사이의 총합을 계산
    public int sumNumber() {
        for(int i = start; i <= end; i++){
            sumNum += i;
        } return sumNum;
    }

    // 2번 메소드
    // 원하는 두 숫자 사이에서
    // 원하는 숫자의 배수를 출력
    public List<Integer> printMultipleNumberList(int multipleNum){
        for(int i = start; i <= end; i++){
            if(i % multipleNum == 0){
                numberList.add(i);
            }
        } return numberList;
    }

    // 3번 메소드
    // 인덱스 0번 값과 1번 값의 차이를 계산하고 -> 2
    // 원하는 인덱스에서 -1을 뺀 값에 차이를 곱한다.
    // 인덱스 0번 값에 위 값을 더하여 원하는 인덱스의 값을 찾는다.
    public int printPro15(int index){
        final int firstNum = numberList.get(0);
        final int difference = numberList.get(1) - firstNum;

        return firstNum + difference * (index - 1);
    }

}
