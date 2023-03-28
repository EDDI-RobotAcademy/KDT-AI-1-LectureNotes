package repeat.listTest;

import java.util.ArrayList;
import java.util.List;

public class IntegerListTest {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        // 데이터 타입을 정수형으로
        // <>에 데이터 타입. 클래스를 놓을 수도 있음
        // 우리 과제는 그냥 String으로 출력할 것

        for (int i = 0; i < 7; i++) {
            integerList.add(i + 1);
            System.out.println("저장된 결과 출력: " + integerList.get(i));
        }
    }
}
