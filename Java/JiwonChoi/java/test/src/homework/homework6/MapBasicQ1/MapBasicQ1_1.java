package homework.homework6.MapBasicQ1;
import java.util.HashMap;
import java.util.Map;

//1. 사람의 이름과 나이를 map에 저장해서 출력해봅시다!
public class MapBasicQ1_1 {
    static Map <String, Integer> personInfo = new HashMap<>(); //personInfo라는 map생성

    public static void main(String[] args) {
        personInfo.put("김땡땡", 20);  //map personInfo에 요소 추가
        personInfo.put("이땡땡", 21);
        personInfo.put("박땡땡", 22);

        System.out.println(personInfo); //map personInfo 출력
        System.out.println(personInfo.get("이땡땡")); //이땡땡에 해당하는 값=21출력
        System.out.println(personInfo.get("최땡땡")); //최땡땡에 해당하는 값이 없어서 null출력
    }

}
