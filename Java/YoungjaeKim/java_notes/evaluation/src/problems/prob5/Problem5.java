package problems.prob5;

import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static void main (String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        final int startNumber = 3;
        int sum = 0;

        // i = (i-1) + (i-3)
        for (int i = 0; i < 20; i++) {
            if (i == 0) {
                list.add(startNumber);
            } else if ((i - 3) < 0) {
                sum = list.get(i-1);
                list.add(sum);
            } else {
                sum = list.get(i-1) + list.get(i-3);
                list.add(sum);
            }
        }

        System.out.println(list);
        System.out.println("20번째 숫자 : " + list.get(19));
    }
}
