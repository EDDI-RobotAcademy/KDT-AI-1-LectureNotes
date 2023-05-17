package problems.prob5;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static void main(String[] args) {

        final int startNumber = 3;

        List<Integer> guessTwenty = new ArrayList<>();

        guessTwenty.add(startNumber);
        guessTwenty.add(startNumber);
        guessTwenty.add(startNumber);

        for (int i = 0; guessTwenty.size() < 20; i++) { // 크기가 20이 될 때까지
            int nextNumber = guessTwenty.get(i) + guessTwenty.get(i+2);

            guessTwenty.add(nextNumber);
        }

        System.out.println("현재 ' " + guessTwenty.size() + " ' 개의 숫자가 나왔습니다.");
        System.out.println(guessTwenty + "이므로 ");
        System.out.println("20번째 숫자는 : " + guessTwenty.get(19));








    }
}
