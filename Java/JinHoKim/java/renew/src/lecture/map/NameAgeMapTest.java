package lecture.map;

import java.util.HashMap;
import java.util.Map;

class NameAge {

    final Map<String, Integer> mapNameAge = new HashMap<>();

    public NameAge (String name, int age) {
        mapNameAge.put(name, age);
    }

    public int getAge (String name) {
        return mapNameAge.get(name);
    }
}

public class NameAgeMapTest {
    public static void main (String[] args) {
        NameAge nameAge = new NameAge("안녕", 7);
        int age = nameAge.getAge("안녕");
        System.out.println("age = " + age);
    }
}
