package problems.prob12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import customLibrary.CustomRandom;

// 12번, 13번 해결 완료
public class Problem12 {
    public static void main (String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        final int student = 20;
        final int GRADE_MIN = 0;
        final int GRADE_MAX = 100;
        int sum = 0;

        for (int i = 0; i < student; i++) {
            list.add(CustomRandom.generateNumber(GRADE_MIN, GRADE_MAX));
        }
        System.out.println(list);

        for (int num: list) {
            sum += num;
        }
        System.out.println("점수 합계 : " + sum);

        System.out.println("평균 점수 : " + (double) sum / list.size());

        // 동일 점수에 대한 등수 차이는 해결되지 않았음
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+1 + "위 : " + list.get(i));
        }
    }
}
