package problems.prob27;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    final private int PLAYER_NUM = 10;
    List<Player> playerList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("플레이어" + (i + 1)));
        }
    }

    public void playGame() throws InterruptedException {
        int turn = 0;
        for (; ; turn++) {
            System.out.println("현재 턴: " + (turn + 1));

            final Boolean isSomeoneDead = playTurn(turn);
            if (isSomeoneDead) {
                System.out.println("누군가의 체력이 0이므로 게임을 종료합니다.");
                break;
            }
            printPlayerInfo();


            Thread.sleep(1000);
        }
    }

    private boolean playTurn(int turn) {
        final int DECISION_ODD = 1;
        final int DECISION_EVEN = 0;
        final int DECISION_MAKER = 2;

        for (int playerIdx = 0; playerIdx < PLAYER_NUM; playerIdx++) {
            Player player = playerList.get(playerIdx);
            int decisionDice = player.getDiceList().get(turn).getDiceNum();
            System.out.println((playerIdx+1) + "이 던진 주사위는" + decisionDice);
            if (decisionDice % DECISION_MAKER == DECISION_ODD) {
                for (int targetPlayerIdx = 0; targetPlayerIdx < PLAYER_NUM; targetPlayerIdx++) {
                    if (targetPlayerIdx % DECISION_MAKER == DECISION_ODD) {
                        playerList.get(targetPlayerIdx).setHealth(playerList.get(targetPlayerIdx).getHealth() - 1);
                    }
                }
            } else {
                for (int targetPlayerIdx = 0; targetPlayerIdx < PLAYER_NUM; targetPlayerIdx++) {
                    if (targetPlayerIdx % DECISION_MAKER == DECISION_EVEN) {
                        playerList.get(targetPlayerIdx).setHealth(playerList.get(targetPlayerIdx).getHealth() - 1);
                    }
                }
            }
            if (player.getHealth() == 0) {
                return true;
            }
        }
        return false;
    }

    private void printPlayerInfo() {
        System.out.println("현재 플레이어들의 정보");
        System.out.println(playerList);

    }
}
