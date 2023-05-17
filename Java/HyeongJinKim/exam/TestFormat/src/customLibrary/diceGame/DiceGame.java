package customLibrary.diceGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiceGame {
    private List<Player> playerList;
    final private String[] nameArray = {
            "고고싱", "가즈아", "간드아", "이그죠", "레츠고",
            "안녕", "하이", "곤치니와", "곰방와", "헬로"
    };

    public DiceGame() {
        this.playerList = new ArrayList<>();

        for (int i = 0; i < nameArray.length; i++) {
            playerList.add(new Player(nameArray[i]));
        }
    }

    public void applyDiceAbility() {
        final int DECISION_EVEN = 2;
        final int EVEN = 0;
        final int ODD = 1;

        for (int playerIdx = 0; playerIdx < playerList.size(); playerIdx++) {
            final Player player = playerList.get(playerIdx);
            final Dice dice = player.getDice();
            final int diceNumber = dice.getDiceNumber();

            if (diceNumber % DECISION_EVEN == EVEN) {
                attackEverySpecificIndexPlayer(playerList.size(), ODD);
            } else {
                attackEverySpecificIndexPlayer(playerList.size(), EVEN);
            }

            System.out.println("현재 인덱스: " + playerIdx);
            System.out.println(playerList);

            removeDeadPlayer();
        }
    }

    private void removeDeadPlayer() {
        for (int j = 0; j < playerList.size(); j++) {
            final Player player = playerList.get(j);
            final Dice dice = player.getDice();
            final int diceNumber = dice.getDiceNumber();

            if (diceNumber <= 0) {
                playerList.remove(j);
            }
        }
    }

    private void attackEverySpecificIndexPlayer(int playerCount, int type) {
        final int JUMP_IDX = 2;

        for (int i = type; i < playerCount; i += JUMP_IDX) {
            final Player player = playerList.get(i);
            final Dice dice = player.getDice();

            dice.subtractDiceNumber();
        }
    }

    public void printRank() {
        int rank = 1;
        int backupScore = 0;
        int sameScoreCount = 0;
        Boolean isSameScore = false;

        Collections.sort(playerList, Collections.reverseOrder());

        for (int i = 0; i < playerList.size(); i++) {
            isSameScore = false;

            final Player player = playerList.get(i);
            final int currentScore = player.getDice().getDiceNumber();
            if (backupScore == currentScore) {
                sameScoreCount++;
                isSameScore = true;
            } else { sameScoreCount = 0; }

            System.out.println(
                    "순위: " + ((isSameScore) ? (rank++ - sameScoreCount) : (rank++))+
                    ", 점수: " + currentScore +
                    ", 이름: " + player.getName());

            backupScore = player.getDice().getDiceNumber();
        }
    }

    @Override
    public String toString() {
        return "DiceGame{" +
                "playerList=" + '\n' + playerList +
                '}';
    }
}
