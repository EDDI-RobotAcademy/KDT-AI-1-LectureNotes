package problems.prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Random random = new Random();

        // A부터 J까지의 아스키코드 값
        final int START = 65;
        final int END = 74;

        for (int i = START; i <= END; i++) {
            list.add(String.valueOf((char) i));
        }

        System.out.println(list);

        // 리스트의 크기(10)만큼 랜덤하게 출력 (중복확인 X)
        for (int i = 0; i < list.size(); i++) {
            System.out.print((list.get(random.nextInt(10))) + ", ");
        }
    }
}
