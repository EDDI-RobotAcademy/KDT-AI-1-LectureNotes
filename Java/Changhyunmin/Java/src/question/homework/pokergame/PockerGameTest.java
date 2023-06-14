package question.homework.pokergame;

import question.homework.pokergame.Player;

import java.util.*;

public class PockerGameTest {
    public static void main(String[] args) {

        Player[]  players;
        System.out.print("player의 수를 입럭해주세요 > ");
        int numOfPlayer = new Scanner(System.in).nextInt();
        players =new Player[numOfPlayer];

        for (int i = 0; i < numOfPlayer; i++){
            players[i] = new Player();
            players[i].money = 10000;
        }
        int index = 0;

        while (true){
            System.out.println("계속하기:1" + '\'' + "중지하기:2");
            index = new Scanner(System.in).nextInt();
            if (index == 1){
                Dealer dealer = new Dealer();

                for (int i = 0; i < numOfPlayer; i++){
                    dealer.deal(players[i]);
                    Arrays.sort(players);
                    System.out.println("플레이어 " + (i + 1) + " " +
                            Arrays.toString(players[i].cards));
                    players[i].money -= 10000;
                }
                dealer.checkPank(players);
                int ranking[] = new int [numOfPlayer];
                for (int i = 0; i < numOfPlayer; i++){
                    ranking[i] = players[i].rank;
                }
                Arrays.sort(ranking);
                System.out.println(Arrays.toString(ranking));
                int WinnerRank = ranking[numOfPlayer-1];
                for (int i = 0; i < numOfPlayer; i++) {
                    if (players[i].rank == WinnerRank) {
                        System.out.println(i + 1 + "번째 플레이어가 승리했습니다.");
                        players[i].money += (10000 * (numOfPlayer));
                    }
                }
            }else if (index == 2) {
                int maxmoney = players[0].money;

                for (int i = 1; i < numOfPlayer; i++) {
                    if (maxmoney < players[i].money) {
                        maxmoney = players[i].money;
                        System.out.println((i+1) + "플레이어가 가진 돈" + maxmoney +
                                "원 으로 가자 많습니다." + '\n' + "승리하셨습니다.");
                    }else continue;
                }
            }
        }
    }

}
