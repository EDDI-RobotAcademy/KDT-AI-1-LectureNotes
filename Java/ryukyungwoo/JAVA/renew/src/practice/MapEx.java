package practice;

import java.util.HashMap;
import java.util.Map;

public class MapEx {
    final String name;
    final int value;
    public MapEx (String name, int value) {
        Map<String, Integer> mapEx = new HashMap<>();
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MapEx{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {

        System.out.println(new MapEx("이름", 123));
//
//        MapEx mapEx = new MapEx("이름", 123);
//
//        System.out.println(mapEx);
//        Map<String, Integer> mapEx = new HashMap<>();
//
//        final String name;
//        final Integer value;
//
//        mapEx.put("정보", 123123);
//        System.out.println(mapEx);

    }

}
