package dice3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    String playerName1;
    String playerName2;

    int addStart = 1; // 플레이어 추가에 필요한 숫자
    int START = 0; // 기본 시작 숫자

    List<String> playerName = new ArrayList<>(); // 플레이어 이름을 담아줄 리스트
    int playerMany; // 플레이어의 명 수

    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);

    public List<String> addPlayer() {

        System.out.print("몇 명이서 플레이 하실 겁니까? : ");
        playerMany = sc.nextInt();

        for (int i = addStart; i <= playerMany; i++){
            System.out.print(i + " 번 플레이어의 이름을 입력해주세요 : ");
            playerName.add(sc1.nextLine());
        }

        for (int i = START; i < playerMany; i++){
            System.out.println(i+1 + " 번째 선수의 이름은 !! " + playerName.get(i) + " 입니다 !!");
        }

        System.out.println("----------------------------------------------------------");

        return playerName;

    }

}
