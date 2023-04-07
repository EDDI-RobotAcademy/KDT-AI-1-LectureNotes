package homework;

import java.util.HashMap;
import java.util.Map;

public class MapExample2 {
    public static void main(String[] args) {
        Map<String, String> nameNumber = new HashMap<>();
        nameNumber.put("김형진", "010-1111-1111");
        nameNumber.put("이형진", "010-2222-2222");
        nameNumber.put("삼형진", "010-3333-3333");
        System.out.println(nameNumber);
    }
}

/*
2. 친구의 이름과 전화 번호를 map에 저장해서 출력해봅시다.
*/
