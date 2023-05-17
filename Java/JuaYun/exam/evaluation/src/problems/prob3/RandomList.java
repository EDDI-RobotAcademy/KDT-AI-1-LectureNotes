package problems.prob3;

import problems.CustomRandom;

import java.util.ArrayList;
import java.util.List;

// 문자열 10개를 리스트에 넣고 랜덤으로 출력해봅시다.
public class RandomList {

    List<String> stringList = new ArrayList<>();

    public RandomList() {
        for (int i = 0; i < 5; i++) {
            char ch = (char) CustomRandom.generateNumber(65,74);
            stringList.add(String.valueOf(ch));
            // stringList 에 새로운 요소를 추가하려면
            // stringList.add() 메서드를 사용해야 한다.
            // String.valueOf() 를 사용하여 char 값을
            // String 으로 변환 할 수 있음
            // 내가 원래 작성했던 코드는 stringList.get(ch) 였음
        }
            System.out.println(stringList);
    }
}
