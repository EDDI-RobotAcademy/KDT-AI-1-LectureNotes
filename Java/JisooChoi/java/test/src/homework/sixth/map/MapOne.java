package homework.sixth.map;

import java.util.HashMap;

public class MapOne {
    public static void main(String[] args) {
        HashMap<String, Integer> nameAndAge = new HashMap<>();

        nameAndAge.put("최지수", 10);
        nameAndAge.put("홍길동", 20);
        nameAndAge.put("성춘향", 30);
        nameAndAge.put("이몽룡", 40);

        System.out.println(nameAndAge);

        System.out.println(nameAndAge.get("최지수"));
    }
}
