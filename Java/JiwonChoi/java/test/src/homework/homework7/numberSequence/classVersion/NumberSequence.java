package homework.homework7.numberSequence.classVersion;

import java.util.ArrayList;

public class NumberSequence {
    int START_NUM;
    int END_NUM;
    int EVEN = 0;

    public NumberSequence(int START_NUM, int END_NUM) { //생성자
        this.START_NUM = START_NUM;
        this.END_NUM = END_NUM;
    }

    public void BasicNumberList() { //START_NUM~END_NUM까지 출력
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = START_NUM; i <= END_NUM; i++) {
            numberList.add(i);
        }
        System.out.println(numberList);
    }

    public ArrayList<Integer> DecisionNumberList(int decisionNum) { //START_NUM~END_NUM까지 decisionNum배수만 출력
        ArrayList<Integer> decisionNumberList = new ArrayList<>();
        for (int i = START_NUM; i <= END_NUM; i++) {
            if (i % decisionNum == EVEN) {
                decisionNumberList.add(i);
            } else {
            }
        }
        System.out.println(decisionNumberList);

        return decisionNumberList;
    }

    public void DecisionNumberAndSumList(int decisionNum) { //START_NUM~END_NUM까지 decisionNum배수만 출력, 합산 출력
        ArrayList<Integer> decisionNumberAndSumList1 = DecisionNumberList(decisionNum);
        int tmpSum = 0;
        for (int i = 0; i < decisionNumberAndSumList1.size(); i++) {
            tmpSum += decisionNumberAndSumList1.get(i);
        }

        System.out.println(tmpSum);
    }
}
