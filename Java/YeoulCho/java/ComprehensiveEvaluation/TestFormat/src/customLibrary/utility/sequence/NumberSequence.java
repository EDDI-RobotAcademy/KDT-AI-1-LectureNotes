package customLibrary.utility.sequence;

import java.util.List;

public class NumberSequence {
    private int START;
    private int END;
    private int totalSum;

    private List<Integer> numberList;

    public NumberSequence(int start, int end){
        this.START = start;
        this.END =end;
    } // 생성자 만들기

    public NumberSequence(List<Integer> numberList) {
        this.numberList = numberList;
    } // 리스트형 생성자도 만들기

    public void addThroughout(){ //더하기 메서드 생성
        totalSum =0;
        for(int i=START; i<=END;i++){
            totalSum += i;
        }
    }
    public void addThrounghoutCondition(int condition){
        totalSum =0;
        for(int i=START; i<=END;i++) {
            if (i % condition == 0) {
                totalSum += i;
            }
        }
    }
    public void printTargetList(int targetNumber) {
        System.out.printf("%d ~ %d 범주내 %d의 배수를 출력합니다.\n",
                START, END, targetNumber);

        for (int i = START; i <= END; i++) {
            if (i % targetNumber == 0) {
                System.out.printf("%d, ", i);
            }
        }
    }


    public int getTotalSum() {
        return totalSum;
    }
}
