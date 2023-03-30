package homework.homework6.MapBasicQ1;
import java.util.HashMap;
import java.util.Map;

//4. 친구 별명과 실명을 map에 저장해서 출력해봅시다.
public class MapBasicQ1_4 {
    static Map<String, String> FriendNicnameMap = new HashMap<>();

    public static void main(String[] args) {
        FriendNicnameMap.put("김00", "사과");
        FriendNicnameMap.put("이00", "바나나");
        FriendNicnameMap.put("박00", "커피");

        System.out.println(FriendNicnameMap);
        System.out.println(FriendNicnameMap.get("김00"));
    }
}
