package problems.prob12.q3Sequence;

import java.util.ArrayList;

public class Sequence {

    public static void main(String[] args) {
        ArrayList<Integer> oddNumber = new ArrayList<>();
        int numberth = 273;
        int indexNum = numberth - 1;

        for (int i = 0; i < numberth*2 ; i++) {
            if(i % 2 != 0) {
                oddNumber.add(i);
            }
        }
        System.out.println(oddNumber.get(indexNum));
    }
}
