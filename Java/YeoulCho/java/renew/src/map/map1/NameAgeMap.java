package map.map1;

import java.util.HashMap;
import java.util.Map;

public class NameAgeMap {
    Map<String, Integer> NameAgeMap = new HashMap<>();
    public NameAgeMap(String Name, int age){
        NameAgeMap.put(Name, age);
    }

    public int getAge(String Name){ //숫자형을 반환 할꺼니까 int
     return NameAgeMap.get(Name);
    }

    @Override
    public String toString() {
        return "NameAgeMap{" +
                "NameAgeMap=" + NameAgeMap +
                '}';
    }
}
