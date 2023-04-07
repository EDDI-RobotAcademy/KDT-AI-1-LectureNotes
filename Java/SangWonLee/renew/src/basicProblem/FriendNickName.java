package basicProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FriendNickName {

    public static void main(String[] args) {

        String FriendNN;
        String FriendRN;
        Map<String, String> FNN = new HashMap<>();

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);

        System.out.println("친구 닉네임 입력 : ");
        FriendNN = sc1.nextLine();

        System.out.println("친구 진짜 이름 입력 : ");
        FriendRN = sc2.nextLine();

        FNN.put(FriendNN,FriendRN);

        System.out.println("친구 닉네임 입력하세요 : ");
        String FNNgo = sc3.nextLine();

        System.out.println(FNN.get(FNNgo));
    }





}
