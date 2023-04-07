package map.map1;

public class reMapTest {
    public static void main(String[] args) {
        NameAgeMap nameAgeMap = new NameAgeMap("가나다", 10);
        System.out.println(nameAgeMap);

        int age = nameAgeMap.getAge("가나다"); //key(이름) 값을 통해 value(age) 값 찾기
        System.out.println(age);
    }
}
