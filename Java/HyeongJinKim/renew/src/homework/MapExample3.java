package homework;

import java.util.HashMap;
import java.util.Map;

public class MapExample3 {
    public static void main(String[] args) {
        Map<Integer, String> hotkeyNumber = new HashMap<>();
        hotkeyNumber.put(1, "010-0000-0000");
        hotkeyNumber.put(2, "010-1111-1111");
        hotkeyNumber.put(3, "010-2222-2222");
        System.out.println(hotkeyNumber);
    }
}

/*
3. 단축 번호와 전화 번호를 map에 저장해서 출력해봅시다.
*/
