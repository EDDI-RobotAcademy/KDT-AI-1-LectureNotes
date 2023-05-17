



package problems.prob27;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceGameManager {



        public List<Player> addPlayer(){ // 플레이어 추가하기

            final int START = 0;

            final List<Player> playerNameList = new ArrayList<>(); // 플레이어 이름 리스트

            Scanner sc = new Scanner(System.in); // 몇 명인지 물어볼 때에 쓰일 Scanner
            Scanner sc1 = new Scanner(System.in); // 플레이어 이름 입력에 쓰일 Scanner

            System.out.print("몇 명이서 플레이 하실 겁니까? : ");
            int playerMany = sc.nextInt();

            int addStart = 1; // 플레이어 추가에 필요한 숫자
            for (int i = addStart; i <= playerMany; i++) {
                System.out.print(i + " 번 플레이어의 이름을 입력해주세요 : ");
                playerNameList.add(new Player(sc1.nextLine()));

            }

            for (int i = START; i < playerMany; i++) {
                System.out.println(i + 1 + " 번째 선수의 이름은 !! " + playerNameList.get(i) + " 입니다 !!");
            }
            return playerNameList;
        }

}
