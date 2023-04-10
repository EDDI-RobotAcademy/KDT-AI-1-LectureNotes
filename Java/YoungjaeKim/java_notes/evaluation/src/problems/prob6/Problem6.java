package problems.prob6;

import java.util.List;
import java.util.ArrayList;

public class Problem6 {
    public static void main (String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        final int START = 50;
        final int END = 100;

        for (int i = START; i <= END; i++) {
            if (i % 5 == 0) {
                list.add(i);
            }
        }

        System.out.println(list);
    }
}
