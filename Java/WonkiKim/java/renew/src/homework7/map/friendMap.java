package homework7.map;

import utility.random.CustomRandom;

import java.util.HashMap;
import java.util.Map;

public class friendMap {
    public static void main(String[] args) {
        Map<String, String> friendMap = new HashMap<>();

        for(int i=0; i<10; i++) {
            String phoneNumberPart1 = "010";
            String phoneNumberPart2 = "-"+CustomRandom.generateNumber(9999);
            String phoneNumberPart3 = "-"+CustomRandom.generateNumber(9999);

            friendMap.put("friend"+i, phoneNumberPart1+phoneNumberPart2+phoneNumberPart3);
        }
        System.out.println(friendMap);
    }
}
