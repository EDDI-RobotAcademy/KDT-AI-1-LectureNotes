package homework.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FriendPhoneNumber {
    public static void main(String[] args) {

        final Map<String, Integer> friendName = new HashMap<>();

        final String name;
        final int phoneNumber;
        String findname;

        Scanner scan = new Scanner(System.in);
        System.out.println("친구의 이름과 전화번호를 입력하세요.");
        name = scan.next();
        phoneNumber = scan.nextInt();

        friendName.put(name,phoneNumber);

        System.out.println("친구의 이름으로 전화번호를 조회하세요.");
        findname = scan.next();

        if(friendName.get(findname) == null){
            System.out.println("등록되어 있지 않습니다.");
        } else {
            System.out.println(friendName.get(findname));
        }
    }
}
