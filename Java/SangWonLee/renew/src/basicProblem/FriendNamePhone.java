package basicProblem;

import java.util.*;
import java.util.function.BiConsumer;

public class FriendNamePhone {

    public static void main(String[] args) {
        // 친구의 이름과 전화 번호를 map에 저장해서 출력

        String FriendName;
        int FriendPhone;
        Map<String,Integer> FNP = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("친구 이름을 입력하세요 : ");
        FriendName = sc.nextLine();

        System.out.println("친구 전번을 입력하세요 : ");
        FriendPhone = sc.nextInt();

        FNP.put(FriendName, FriendPhone);
        sc.nextLine();

        System.out.println("폰번을 보고 싶은 친구 이름을 입력 하세요 : ");
        String seeFriendPhone = sc.nextLine();

        System.out.println(FNP.get(seeFriendPhone));











    }


}
