package homework;

import java.util.HashMap;
import java.util.Map;

public class MapExample4 {
    public static void main(String[] args) {
        Map<String, String> nameNickname = new HashMap<>();
        nameNickname.put("김형진", "ㄱㅎㅈ");
        nameNickname.put("이형진", "ㅇㅎㅈ");
        nameNickname.put("삼형진", "ㅅㅎㅈ");
        System.out.println(nameNickname);
    }
}

/*
4. 친구 별명과 실명을 map에 저장해서 출력해봅시다.
*/