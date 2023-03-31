package homework.seventh.mapquiz;

import java.util.HashMap;
import java.util.Map;

public class MapQuiz1 {
    public static void main(String[] args) {

        Map<String, Integer> peopleMap = new HashMap<>();
        peopleMap.put("김",22);
        peopleMap.put("박",24);

        System.out.println(peopleMap);
    }
}
