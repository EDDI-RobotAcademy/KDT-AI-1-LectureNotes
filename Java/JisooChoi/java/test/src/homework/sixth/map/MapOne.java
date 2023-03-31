package homework.sixth.map;

import java.util.HashMap;

public class MapOne {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("최지수", 10);
        map.put("홍길동", 20);
        map.put("성춘향", 30);
        map.put("이몽룡", 40);

        System.out.println(map);

        System.out.println(map.get("최지수"));
    }
}
