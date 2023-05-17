package problems.prob12;

import java.util.ArrayList;
import java.util.List;

public class SequenceProblem {
    public static void main(String[] args) {

        int sequenceNumber = 0;
        int findNumber = 273;
        List<Integer> sequenceNumberList = new ArrayList<>();

        while (sequenceNumberList.size() < findNumber){
            sequenceNumber++;
            if (sequenceNumber % 2 == 1) {
                sequenceNumberList.add(sequenceNumber);
            }
        }
        System.out.println("현재 리스트의 갯수는 : " + sequenceNumberList.size());
        System.out.println(sequenceNumberList);
        System.out.println(findNumber + "번째 숫자는 : " + sequenceNumber + " 입니다. ");



    }

}
