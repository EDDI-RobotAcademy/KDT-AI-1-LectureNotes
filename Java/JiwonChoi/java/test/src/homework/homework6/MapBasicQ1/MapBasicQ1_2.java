package homework.homework6.MapBasicQ1;
import java.util.HashMap;
import java.util.Map;

//2. 친구의 이름과 전화 번호를 map에 저장해서 출력해봅시다.
public class MapBasicQ1_2 {
    private static Map<String, Long> FriendInfo1Map = new HashMap<>();
    private static Map<String, String> FriendInfo2Map = new HashMap<>();

    public static void main(String[] args) {
        FriendInfo1Map.put("김00", 01011112222L);
        FriendInfo1Map.put("이00", 01022223333L);
        FriendInfo1Map.put("박00", 01033332222L);

        System.out.println(FriendInfo1Map);
        System.out.println(FriendInfo1Map.get("김00"));


        FriendInfo2Map.put("김00", "01011112222");
        FriendInfo2Map.put("이00", "01022223333");
        FriendInfo2Map.put("박00", "01033332222");
        //숫자로는 못하는건가??

        System.out.println(FriendInfo2Map);
        System.out.println(FriendInfo2Map.get("김00"));
    }

}
