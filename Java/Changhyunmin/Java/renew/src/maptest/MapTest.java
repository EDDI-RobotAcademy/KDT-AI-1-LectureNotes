package maptest;

import java.util.*;

public class MapTest {
/*1. 사람의 이름과 나이를 map에 저장해서 출력해봅시다!
2. 친구의 이름과 전화 번호를 map에 저장해서 출력해봅시다.
3. 단축 번호와 전화 번호를 map에 저장해서 출력해봅시다.
4. 친구 별명과 실명을 map에 저장해서 출력해봅시다.*/
    public static void main(String[] args) {
        //01
        Map<String, Integer>map = new HashMap<>();
        map.put("장현민", 26);
        map.put("훈", 27);
        //02
        Map<String, String>phone = new HashMap<>();
        phone.put("훈", "010-yyyy-yyyy");
        //03
        Map<Integer, String> num = new HashMap<>();
        num.put(1,"010-8555-7814");
        num.put(2,"010-xxxx-xxxx");
        //04
        Map<String, String> name = new HashMap<>();
        name.put("청주", "훈");


        //01
        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
            String key = (String)entry.getKey();
            int value = (Integer)entry.getValue();

            System.out.println("이름: " + key);
            System.out.println("나이: " + value);
            System.out.print('\n');
        }
        System.out.println(map);
        System.out.print('\n');
        //02
        for (Map.Entry<String,String> elem : phone.entrySet()){
            System.out.println("이름: " + elem.getKey() +
                    '\n' + "전화번호: " + elem.getValue());
        }
        System.out.println(phone);
        System.out.print('\n');
        //03
        for (Map.Entry<Integer,String> elem2 : num.entrySet()){
            System.out.println( elem2.getKey() + ".전화번호"
                    + elem2.getValue());
        }
        System.out.println(num);
        System.out.print('\n');
        //04
        Set set2 = phone.entrySet();
        Iterator iterator2 = set2.iterator();

        while (iterator2.hasNext()){
            Map.Entry<String, String>entry2 = (Map.Entry<String, String>)
                    iterator2.next();
            String key = (String) entry2.getKey();
            String value = (String)entry2.getValue();
            System.out.println("별명: " + key);
            System.out.println("이름: " + value);
        }
        System.out.println(name);
    }
}
