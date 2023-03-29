package homework.map1;

import java.util.HashMap;
import java.util.Map;
class NameAge {
    public static void main(String[] args) {
        Map<String, Integer> mapNameAge = new HashMap<>();

        final String name;
        final int age;

        mapNameAge.put("홍길동", 100);
        System.out.println(mapNameAge);
    }

}
class FriendNamePhoneNumber {
        public static void main(String[] args) {
            Map<String, String> mapFriendNamePhoneNumber = new HashMap<>();

            final String friendName;
            final String PhoneNumber;

            mapFriendNamePhoneNumber.put("홍길동", "01000000000");
            System.out.println(mapFriendNamePhoneNumber);
        }
}
class SetNumberPhoneNumber {
    public static void main(String[] args) {
        Map<Integer, String> mapSetNumberPhoneNumber = new HashMap<>();

        final Integer setNumber;
        final String phoneNumber;

        mapSetNumberPhoneNumber.put(1,"홍길동");
        System.out.println(mapSetNumberPhoneNumber);
    }
}
class FriendNicknameRealname {
    public static void main(String[] args) {
        Map<String, String> mapFriendNicknameRealname = new HashMap<>();

        final String friendNickname;
        final String realname;

        mapFriendNicknameRealname.put("홍길동", "홍길동");
        System.out.println(mapFriendNicknameRealname);
    }

}
public class TestMap {
    public static void main(String[] args) {
        System.out.println(new NameAge());
    }
}
