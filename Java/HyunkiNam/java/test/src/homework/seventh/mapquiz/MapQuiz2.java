package homework.seventh.mapquiz;

import java.util.HashMap;
import java.util.Map;

// 이름 전화번호
class Friend{
    final String name;
    final String number;
    public Friend(String name, String number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
public class MapQuiz2 {
    public static void main(String[] args) {
        Friend friend = new Friend("철수","010-1234-5678");
        Map<String, String> friendMap = new HashMap<>();

        friendMap.put(friend.getName(), friend.getNumber());

        System.out.println(friendMap);
    }
}
