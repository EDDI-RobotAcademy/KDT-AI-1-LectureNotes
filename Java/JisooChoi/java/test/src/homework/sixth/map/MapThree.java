package homework.sixth.map;

import java.util.HashMap;

public class MapThree {
    public static void main(String[] args) {
        HashMap<Integer, String> numberMap = new HashMap<>();

        numberMap.put(1, "010-1111-1111");
        numberMap.put(2, "010-2222-2222");
        numberMap.put(3, "010-3333-3333");

        System.out.println(numberMap);

        for(int i = 1; i <= numberMap.size(); i++){
            System.out.println(numberMap.get(i));
        }
    }
}
