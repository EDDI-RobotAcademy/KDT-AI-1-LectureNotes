package problems.prob3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {

        List<String> letterList = new ArrayList<>();

        letterList.add("A");
        letterList.add("B");
        letterList.add("C");
        letterList.add("D");
        letterList.add("E");
        letterList.add("F");
        letterList.add("G");
        letterList.add("H");
        letterList.add("I");
        letterList.add("J");

        Collections.shuffle(letterList);

        for(int i = 0; i < letterList.size(); i++) {
            System.out.println(letterList.get(i));
        }

    }
}
