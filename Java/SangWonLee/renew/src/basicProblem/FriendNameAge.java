package basicProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FriendNameAge {

    // 친구의 이름과 나이를 map에 저장해서 출력하기

    public static void main(String[] args) {

        String friendName;
        int friendAge;
        Map<String,Integer> FNA = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("친구의 이름을 입력해주세요. : ");
        friendName = sc.nextLine();

        System.out.println("친구의 나이를 입력해주세요. : ");
        friendAge = sc.nextInt();

        FNA.put(friendName,friendAge);
        sc.nextLine();

        System.out.println("보고 싶은 친구의 이름을 입력하세요 : ");
        String seeFriendName = sc.nextLine();

        System.out.println(FNA.get(seeFriendName) + " 살입니다.");










    }




}
