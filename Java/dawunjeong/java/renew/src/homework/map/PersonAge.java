package homework.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonAge {
    public static void main(String[] args) {

        final Map<String, Integer> personName = new HashMap<>();

        final String name;
        final int age;
        final String findAge;

        Scanner scan = new Scanner(System.in);
        System.out.println("사람의 이름과 나이를 입력하세요.");
        name = scan.next();
        age = scan.nextInt();

        personName.put(name,age);

        System.out.println("사람의 이름으로 나이를 조회하세요");
        findAge = scan.next();

        if(personName.get(findAge) == null){
            System.out.println("등록되어 있지 않습니다.");
        } else {
            System.out.println(personName.get(findAge));
        }

    }
}
