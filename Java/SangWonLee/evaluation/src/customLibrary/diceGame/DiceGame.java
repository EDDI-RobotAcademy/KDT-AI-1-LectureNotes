package customLibrary.diceGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiceGame {
    private List<Player> playerList;
    final private String[] nameArray = {
            "고고싱", "가즈아", "간드아", "이그죠", "레츠고",
            "안녕", "하이", "곤치니와", "곰방와", "헬로"
    }; // 사용자 이름 배열

    public DiceGame() {
        this.playerList = new ArrayList<>(); // 선언시 플레이어 리스트 생성

        for (int i = 0; i < nameArray.length; i++) {
            playerList.add(new Player(nameArray[i]));
        }
    }

    public void applyDiceAbility() {
        final int DECISION_EVEN = 2; // 짝수 판별
        final int EVEN = 0; // 나머지가 0일 때 쓰일 것
        final int ODD = 1; // 나머지가 1일 때 쓰일 것

        for (int playerIdx = 0; playerIdx < playerList.size(); playerIdx++) {
                // 플레이어 리스트 사이즈 만큼 (10번)
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
            final Player player = playerList.get(j); // 플레이어 리스트 얻어오기
            final Dice dice = player.getDice(); // 다이스 생성자

            final int diceNumber = dice.getDiceNumber(); // 주사위 넘버 가져오기

            if (diceNumber <= 0) { // 주사위 번호가 0보다 작다면
                playerList.remove(j); // 지금 플레이어 리스트 제거
                // 당황스러운 부분 발견
                // 이렇게 playerList의 데이터를 지우게 되면, playerList.size() 가 작아지는 상황이 발생하면서,
                // 10번 돌아가야할 for문이 5번 돌아가는 상황도 생긴다.
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
