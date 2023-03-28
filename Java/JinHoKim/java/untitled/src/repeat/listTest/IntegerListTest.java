package repeat.listTest;

import java.util.ArrayList;
import java.util.List;

public class IntegerListTest {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < 7; i ++) {
            integerList.add(i + 1);
            System.out.println("저장된 결과 출력: " + integerList.get(i));
        }
    }
}
