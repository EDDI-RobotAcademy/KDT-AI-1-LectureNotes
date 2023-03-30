package homework;

import java.util.HashMap;
import java.util.Map;
public class HomeworkHashMap {
    public static void main(String[] args) {

        // 1 사람의 이름과 나이를 map에 저장해서 출력해봅시다.
        Map<String, Integer> personNameAge = new HashMap<>();
        // 2 친구의 이름과 전화 번호를 map에 저장해서 출력해봅시다.
        Map<String, String> friendNamePhoneNumber = new HashMap<>();
        // 3 단축 번호와 전화 번호를 map에 저장해서 출력해봅시다.
        Map<String, String> speedDialNumber = new HashMap<>();
        // 4 4. 친구 별명과 실명을 map에 저장해서 출력해봅시다.
        Map<String, String> friendNickname = new HashMap<>();

        // 1
        personNameAge.put("연우", 30);
        // 2
        friendNamePhoneNumber.put("루피", "010-1234-5678");
        // 3
        speedDialNumber.put("3", "010-1234-5678");
        // 4
        friendNickname.put("바보", "뽀로로");

        // 1
        System.out.println("연우: " + personNameAge.get("연우"));
        // 2
        String phoneNumber = friendNamePhoneNumber.get("루피");
        System.out.println("루피: " + phoneNumber);
        // 3
        String phoneNumber2 = speedDialNumber.get("3");
        System.out.println("3: " + phoneNumber2);
        // 4
        String realName = friendNickname.get("바보");
        System.out.println("바보: " + realName);
    }
}