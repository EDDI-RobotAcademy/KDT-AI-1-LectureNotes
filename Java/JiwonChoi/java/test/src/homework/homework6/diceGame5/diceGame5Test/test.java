package homework.homework6.diceGame5.diceGame5Test;//package diceGame4_list;


import homework.homework6.diceGame5.diceGame.player.Player;

import static homework.homework6.diceGame5.diceGame.game.GameManager.findTargetPlayerIndex;
import static homework.homework6.diceGame5.diceGame.player.Player.allPlayers;
//import static homework.homework6.diceGame5.diceGame.game.GameManager;

public class test {
    public static void main(String[] args) {
       Player player1 = new Player("김00");
       allPlayers.put(1, player1);

       Player player2 = new Player("이00");
       allPlayers.put(2, player2);

        Player player3 = new Player("박00");
        allPlayers.put(3, player3);

//        GameManager();
        System.out.println(allPlayers);
//        System.out.println(player1.getGameScore());
//        System.out.println(player1.getGameScore().getTotalScore());
        int testIndex = findTargetPlayerIndex(0);
        System.out.println(testIndex);

    }

}

/*
나를 제외한 랜덤상대에게 점수를 뺏어오는 방법으로 만들고 싶었는데
가산부분이 동작하지 않습니다.
 */