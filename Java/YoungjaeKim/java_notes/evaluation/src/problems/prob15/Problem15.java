package problems.prob15;

import java.util.ArrayList;
import java.util.List;

public class Problem15 {
    public static void main (String[] args) {
        // 0부터 시작이므로 273번째 값은 272번에서 찾아야함
        final int search = 272;

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 700; i++) {
            if (i % 2 != 0) {
                list.add(i);
            }
        }

        System.out.println("수열의 273번째 값 : " + list.get(search));
    }
}
