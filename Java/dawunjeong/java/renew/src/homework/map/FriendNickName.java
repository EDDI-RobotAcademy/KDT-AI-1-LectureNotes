package homework.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FriendNickName {
    public static void main(String[] args) {

        final Map<String, String> friendnickname = new HashMap<>();

        final String nickname;
        final String friendname;
        final String findFriendname;

        Scanner scan = new Scanner(System.in);
        System.out.println("친구의 별명과 실명을 입력하세요.");
        nickname = scan.next();
        friendname = scan.next();

        friendnickname.put(nickname,friendname);

        System.out.println("친구의 별명으로 실명을 조회하세요.");
        findFriendname = scan.next();

        if(friendnickname.get(findFriendname) == null){
            System.out.println("등록되어 있지 않습니다.");
        } else {
            System.out.println(friendnickname.get(findFriendname));
        }

    }
}
