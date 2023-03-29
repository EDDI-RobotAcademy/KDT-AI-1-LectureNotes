package homework.sixth.map;

import java.util.HashMap;

public class MapThree {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "010-1111-1111");
        map.put(2, "010-2222-2222");
        map.put(3, "010-3333-3333");

        System.out.println(map);

        for(int i = 1; i <= map.size(); i++){
            System.out.println(map.get(i));
        }
    }
}
