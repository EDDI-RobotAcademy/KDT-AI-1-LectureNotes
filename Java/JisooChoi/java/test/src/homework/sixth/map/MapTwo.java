package homework.sixth.map;

import java.util.HashMap;

public class MapTwo {
    public static void main(String[] args) {
        HashMap<String, String> friendNameAndNumberMap = new HashMap<>();

        friendNameAndNumberMap.put("김보통", "010-1234-5678");
        friendNameAndNumberMap.put("이보통", "010-9101-1121");
        friendNameAndNumberMap.put("박보통", "010-3141-5161");

        System.out.println(friendNameAndNumberMap);

        System.out.println(friendNameAndNumberMap.get("박보통"));
    }
}
