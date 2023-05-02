package problems.prob27;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameManager {
    final private int PLAYER_NUM = 10;
    final private int EVEN_CHECK = 2;
    final private List<Player> playerList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }

    public void playGame(){
        for(int i=0; i<playerList.size(); i++){
            checkDiceNumber(playerList.get(i).getDiceNumber());
        }
    }

    public void checkDiceNumber(int diceNumber){
        final int ODD_START = 0;
        final int EVEN_START = 1;

        if(diceNumber % EVEN_CHECK == 0){
            playerAttack(playerList.size(),ODD_START);
        }
        else {
            playerAttack(playerList.size(),EVEN_START);
        }

        checkDie();
    }

    private void playerAttack(int playerCount, int number) {
        for(int playerIdx=number; playerIdx<playerCount; playerIdx+=2){
            Player player = playerList.get(playerIdx);
            player.setHp(player.getHp()-1);
        }
    }

    private void checkDie(){
        for(int i=0; i<playerList.size(); i++){
            if(playerList.get(i).getHp() <= 0){
                playerList.remove(i);
            }
        }
    }

    public void printRank(){
        int rank = 1;
        int backupHp = 0;
        int sameScoreCount = 0;
        Boolean isSameScore = false;

        playerList.sort(Comparator.comparing(Player::getHp).reversed());

        for (int i = 0; i < playerList.size(); i++) {
            isSameScore = false;

            final Player player = playerList.get(i);
            final int currentHp = player.getHp();
            if (backupHp == currentHp) {
                sameScoreCount++;
                isSameScore = true;
            } else { sameScoreCount = 0; }

            System.out.println(
                    "순위: " + ((isSameScore) ? (rank++ - sameScoreCount) : (rank++))+
                            ", 이름: " + player.getName() +
                            ", HP: " + currentHp);

            backupHp = player.getHp();
        }
    }

    @Override
    public String toString() {
        return "GamaManager{" +
                "playerList=" + playerList +
                '}';
    }
}