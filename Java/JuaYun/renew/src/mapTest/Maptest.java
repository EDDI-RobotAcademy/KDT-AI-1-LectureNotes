package mapTest;

import java.util.HashMap;
import java.util.Map;

public class Maptest {
    public static void main(String[] args) {

        Map<String, Integer> person = new HashMap<>();
        person.put("아무개", 30);
        System.out.println(person);

        System.out.println();

        Map<String, String> friend = new HashMap<>();
        friend.put("아무개", "000-0000-0000");
        System.out.println(friend);

        System.out.println();

        Map<Integer, String> dial = new HashMap<>();
        dial.put(1, "000-0000-0000");
        System.out.println(dial);

        System.out.println();

        Map<String, String> nickname = new HashMap<>();
        nickname.put("아무개", "아무개");
        System.out.println(nickname);
        
    }
}
