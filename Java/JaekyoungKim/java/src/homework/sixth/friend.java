package homework.sixth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class friend {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String,Integer> friendDirectory=new HashMap<>();
        friendDirectory.put("김재경",28);
        friendDirectory.put("이창민",28);
        friendDirectory.put("고은우",28);
        friendDirectory.put("이진환",27);
        friendDirectory.put("김지수",25);
        friendDirectory.put("김지은",28);
        System.out.println(friendDirectory);

        Map<String,String> phoneDirectory=new HashMap<>();
        phoneDirectory.put("박태수","010-1234-1234");
        phoneDirectory.put("이상은","010-2345-2345");
        phoneDirectory.put("한상인","010-3456-3456");
        phoneDirectory.put("김광래","010-4567-4567");
        phoneDirectory.put("유정우","010-5678-5678");
        System.out.println(phoneDirectory);
        System.out.println(phoneDirectory.get("이상은"));

        //단축번호와 phoneDirectory갑 가져오기
        Map<Integer,String> shortenNumber=new HashMap<>();
        shortenNumber.put(1,phoneDirectory.get("박태수"));
        shortenNumber.put(2,phoneDirectory.get("이상은"));
        shortenNumber.put(3,phoneDirectory.get("한상인"));
        shortenNumber.put(4,phoneDirectory.get("김광래"));
        shortenNumber.put(5,phoneDirectory.get("유정우"));
        System.out.println(shortenNumber);

        Map<String,String> nickName=new HashMap<>();
        nickName.put("창구리","이창민");
        nickName.put("j리거","고은우");
        nickName.put("개수","박태수");
        nickName.put("신짜오","임준강");
        nickName.put("위러브","정주찬");
        System.out.println(nickName);
        System.out.println("\n"+"별명을 입력하세요.");

        String nick=scanner.nextLine();
        System.out.println(nickName.get(nick));
        System.out.println(nickName.containsKey("j리거"));








    }
}
