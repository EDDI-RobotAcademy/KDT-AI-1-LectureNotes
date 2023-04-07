package homework;

import java.util.HashMap;
import java.util.Map;

public class March29_Map {
    public static void main(String[] args) {

        // 1. 사람 이름과 나이
        Map<String, String> HumanMap = new HashMap<>();
        HumanMap.put("사람 이름", "김이름");
        HumanMap.put("사람 나이", "20");

        System.out.println("사람 이름: " + HumanMap.get("사람 이름") + ", 나이: " + HumanMap.get("사람 나이"));

        // 2. 친구 이름과 전화 번호
        Map<String, String> FriendMap = new HashMap<>();
        FriendMap.put("친구 이름", "김네임");
        FriendMap.put("친구 전화번호", "010-1234-1234");

        System.out.println("친구 이름: " + FriendMap.get("친구 이름") + ", 친구 전화번호: " + FriendMap.get("친구 전화번호"));

        // 3. 단축 번호와 전화 번호
        Map<String, String> NumberMap = new HashMap<>();
        NumberMap.put("단축 번호", "1");
        NumberMap.put("전화 번호", "010-4321-4321");

        System.out.println("단축 번호: " + NumberMap.get("단축 번호") + ", 전화 번호: " + NumberMap.get("전화 번호"));

        // 4. 친구 별명과 실명
        Map<String, String> NameMap = new HashMap<>();
        NameMap.put("친구 별명", "김뚱이");
        NameMap.put("친구 실명", "김네임");

        System.out.println("친구 별명: " + NameMap.get("친구 별명") + ", 친구 실명: " + NameMap.get("친구 실명"));
    }
}
