package homework.sixth.map;

import java.util.HashMap;

public class MapTwo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("김보통", "010-1234-5678");
        map.put("이보통", "010-9101-1121");
        map.put("박보통", "010-3141-5161");

        System.out.println(map);

        System.out.println(map.get("박보통"));
    }
}
