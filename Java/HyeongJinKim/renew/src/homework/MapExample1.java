package homework;

import java.util.HashMap;
import java.util.Map;

public class MapExample1 {
    public static void main(String[] args) {
        Map<String, Integer> nameAge = new HashMap<>();
        nameAge.put("김형진", 1);
        nameAge.put("이형진", 2);
        nameAge.put("삼형진", 3);
        System.out.println(nameAge);
    }
}

/*
1. 사람의 이름과 나이를 map에 저장해서 출력해봅시다!
*/
