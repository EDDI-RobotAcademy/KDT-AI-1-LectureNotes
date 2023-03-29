package homework.homework6.MapBasicQ1;


import java.util.HashMap;
import java.util.Map;

//2. 친구의 이름과 전화 번호를 map에 저장해서 출력해봅시다.
public class MapBasicQ1_2 {
    private static Map<String, Long> FInfo1 = new HashMap<>();
    private static Map<String, String> FInfo2 = new HashMap<>();

    public static void main(String[] args) {
        FInfo1.put("김00", 01011112222L);
        FInfo1.put("이00", 01022223333L);
        FInfo1.put("박00", 01033332222L);

        System.out.println(FInfo1);
        System.out.println(FInfo1.get("김00"));


        FInfo2.put("김00", "01011112222");
        FInfo2.put("이00", "01022223333");
        FInfo2.put("박00", "01033332222");
        //숫자로는 못하는건가??

        System.out.println(FInfo2);
        System.out.println(FInfo2.get("김00"));
    }

}
