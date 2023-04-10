package homework7.map;

import utility.random.CustomRandom;

import java.util.HashMap;
import java.util.Map;

public class peopleMap {
    public static void main(String[] args) {
        Map<String, Integer> peopleMap= new HashMap<>();
        for (int i=0; i<10; i++) {
            peopleMap.put("people"+i, CustomRandom.generateNumber(100));
        }
        System.out.println(peopleMap);

    }

}
