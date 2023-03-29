package rewiew;

import java.util.ArrayList;
import java.util.List;

public class ILTestReview {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        // 첫 번째 <> 안에 데이터 타입 입력 - 지금은 정수형으로

        // for문 이용
        for (int i = 0; i < 7; i++) {
            integerList.add(i + 1); // add로 리스트에 추가하는 것
            System.out.println(integerList.get(i));

            // 그냥 System.out.println(integerList); 로 출력했을 때 결과물
            // [1]
            // [1, 2]
            // [1, 2, 3]
            // [1, 2, 3, 4]
            // [1, 2, 3, 4, 5]
            // [1, 2, 3, 4, 5, 6]
            // [1, 2, 3, 4, 5, 6, 7]

            // System.out.println(integerList.get(i)); 로 출력했을 때 결과물
            // 1
            // 2
            // 3
            // 4
            // 5
            // 6
            // 7

            // 왜 get을 입력하면 이렇게 출력되지?
        }
    }
}
