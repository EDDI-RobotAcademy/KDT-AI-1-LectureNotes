package homework;

import java.util.HashMap;
import java.util.Map;
public class HomeworkHashMap {
    public static void main(String[] args) {

        // 1 사람의 이름과 나이를 map에 저장해서 출력해봅시다.
        Map<String, Integer> personNameAgeMap = new HashMap<>();
        // 2 친구의 이름과 전화 번호를 map에 저장해서 출력해봅시다.
        Map<String, String> friendNamePhoneNumberMap = new HashMap<>();
        // 3 단축 번호와 전화 번호를 map에 저장해서 출력해봅시다.
        Map<String, String> speedDialNumberMap = new HashMap<>();
        // 4 4. 친구 별명과 실명을 map에 저장해서 출력해봅시다.
        Map<String, String> friendNicknameMap = new HashMap<>();

        // 1
        personNameAgeMap.put("연우", 30);
        // 2
        friendNamePhoneNumberMap.put("루피", "010-1234-5678");
        // 3
        speedDialNumberMap.put("3", "010-1234-5678");
        // 4
        friendNicknameMap.put("바보", "뽀로로");

        // 1
        System.out.println("연우: " + personNameAgeMap.get("연우"));
        // 2
        String phoneNumber = friendNamePhoneNumberMap.get("루피");
        System.out.println("루피: " + phoneNumber);
        // 3
        String phoneNumber2 = speedDialNumberMap.get("3");
        System.out.println("3: " + phoneNumber2);
        // 4
        String realName = friendNicknameMap.get("바보");
        System.out.println("바보: " + realName);
    }
}