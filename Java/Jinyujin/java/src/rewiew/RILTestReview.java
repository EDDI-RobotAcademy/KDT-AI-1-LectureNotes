package rewiew;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RILTestReview {
    public static void main(String[] args) {
        List<Integer> randomIntegerList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            randomIntegerList.add(CustomRandom.generateNumber(7, 33)); // add에다가 뭘 넣느냐를 생각해야 함!
            System.out.println(randomIntegerList.get(i));
        }
    }
}
