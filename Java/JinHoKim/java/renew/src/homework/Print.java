package homework;


import java.util.HashMap;

public class Print {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Name","김진호");
        map.put("Age","26");
        map.put("Friend","호날두");
        map.put("FriendPhone","010-0000-0000");
        map.put("ShortNum","7");
        map.put("Phone","010-2222-2222");
        map.put("NickName","감자도리");
        map.put("FriendName","메시");

        System.out.println("1. 사람의 이름과 나이를 map에 저장해서 출력해봅시다");
        System.out.println("이름: " + map.get("Name") + "\n" + "나이: " + map.get("Age"));
        System.out.println("");

        System.out.println("2. 친구의 이름과 전화번호를 map에 저장해서 출력해봅시다");
        System.out.println("친구 이름: "+ map.get("Friend") + "\n" + "전화번호: " + map.get("FriendPhone"));
        System.out.println("");

        System.out.println("1. 단축 번호와 전화 번호를 map에 저장해서 출력해봅시다");
        System.out.println("단축번호: " + map.get("ShortNum") + "\n" + "전화번호: " + map.get("Phone"));
        System.out.println("");

        System.out.println("1. 친구 별명과 실명을 map에 저장해서 출력해봅시다");
        System.out.println("친구 별명: " + map.get("NickName") + "\n" + "실명: " + map.get("FriendName"));
        System.out.println("");
        // 6
    }
}
