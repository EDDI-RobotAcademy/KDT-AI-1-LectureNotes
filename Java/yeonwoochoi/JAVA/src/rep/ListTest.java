package rep;

import java.util.ArrayList;
import java.util.List;

// 클래스 개념 빼고 리스트만 사용한 것
// 문제 풀 때 클래스 같이 사용하는것을 권장
public class ListTest {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        // 카드 표현 가능
        // 문자는 스트링으로 표현
        for (int i = 0; i < 7; i++)
        {
            integerList.add(i + 1);
            System.out.println("저장된 결과 출력:" + integerList.get(i));
        }
    }
}
