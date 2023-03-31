package map.map1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String , Integer> map1 = new LinkedHashMap<>();//순서개념이 존재하는 HaspMap
        map1.put("김oo",100); // 사람이름, 나이
        map1.put("이oo",101);
        map1.put("강oo",102);
        System.out.println(map1);

        Map<String , String> map2 = new HashMap<>();
        map2.put("김oo","010-1111-2222"); // 사람이름, 전화번호
        map2.put("이oo","010-1111-3333");
        System.out.println(map2);

        Map<Integer, String> map3 = new HashMap<>();
        map3.put(1,"010-1111-2222"); // 단축번호, 전화번호
        map3.put(2, "010-1111-3333");
        System.out.println(map3);

        Map<String, String> map4 =new HashMap<>();
        map4.put("사자", "김oo"); // 별명, 사람이름
        map4.put("호랑이", "이oo");
        System.out.println(map4);



    }
}
