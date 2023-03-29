package homework.homework6.MapBasicQ1;

import java.util.HashMap;
import java.util.Map;

//4. 친구 별명과 실명을 map에 저장해서 출력해봅시다.
public class MapBasicQ1_4 {
    static Map<String, String> FNicname = new HashMap<>();

    public static void main(String[] args) {
        FNicname.put("김00", "사과");
        FNicname.put("이00", "바나나");
        FNicname.put("박00", "커피");

        System.out.println(FNicname);
        System.out.println(FNicname.get("김00"));
    }
}
