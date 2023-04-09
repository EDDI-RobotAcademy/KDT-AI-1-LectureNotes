package homework7.map;

import utility.random.CustomRandom;

import java.util.HashMap;
import java.util.Map;

public class nameMap {
    public static void main(String[] args) {
        Map<String, String> nameMap = new HashMap<>();
        for(int i=0; i<10; i++) {
            nameMap.put("nickName"+i, "realNmae" + i);
        }
        System.out.println(nameMap);
    }
}
