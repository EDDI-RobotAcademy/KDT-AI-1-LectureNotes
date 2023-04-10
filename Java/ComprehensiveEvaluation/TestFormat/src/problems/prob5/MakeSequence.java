package problems.prob5;


import java.util.ArrayList;
import java.util.List;

public class MakeSequence {
    private List<Integer> sequenceList = new ArrayList<>();
    private int sequenceNumber = 20;
    public MakeSequence() {
        sequenceList.add(3);
        sequenceList.add(3);
        sequenceList.add(3);
        for (int i = 4; i <= sequenceNumber ; i++) {
            sequenceList.add(sequenceList.get(i-4)+sequenceList.get(i-2));
        }
    }

    public void getSequenceNumber() {
        System.out.println(sequenceNumber + "번 째 숫자는");
        sequenceNumber = sequenceList.get(sequenceNumber-1);
        System.out.println(sequenceNumber);
       }

}
