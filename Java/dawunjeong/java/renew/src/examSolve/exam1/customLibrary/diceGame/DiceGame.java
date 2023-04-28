package examSolve.exam1.customLibrary.diceGame;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
// 문제 29번
// 주사위의 눈금이 홀수면 짝수 번째 플레이어들의 점수를 1점씩 차감합니다.
// 눈금이 짝수면 홀수 번째 플레이어들의 점수를 1점씩 차감합니다.
// 차감 과정 중 0점이 되면 플레이어를 탈락시킵니다.

public class DiceGame {

    // 이 클래스는 플레이어 리스트를 갖고 있다.
    private List<Player> playerList;
    // 이름 배열을 만들고 10개의 값을 넣어줄 것이다.
    final private String[] nameArray = {"가", "나", "다", "라", "마", "바", "사", "아", "자", "차"};

    // DiceGame 객체를 생성할 때 플레이어 리스트를 생성할 것이고
    // 그 플레이어 리스트에는 플레이어의 객체를 생성하여 넣을 것이다.
    // 플레이어 객체를 생성할 때는 위에 만들어둔 이름 배열의 값을 순차적으로 넣으며 생성할 것이다.
    public DiceGame() {
        this.playerList = new ArrayList<>();

        for (int i = 0; i < nameArray.length; i++) {
            playerList.add(new Player(nameArray[i]));
        }
    }

    // 주사위의 값에 따라 플레이어 점수를 업데이트하는 메소드
    public void applyDiceAbility() {
        final int DECISION_EVEN = 2;
        final int EVEN = 0;
        final int ODD = 1;

        // 플레이어 수만큼 돌면서 값을 비교한다.
        for (int playerIdx = 0; playerIdx < playerList.size(); playerIdx++) {

            // 플레이어 리스트에서 playerIdx 값을 인덱스로 받아와서 player 객체를 생성할 것이다.
            // 그 player 객체의 Dice를 가져와서 dice 객체를 생성할 것이다.
            // 그 dice 객체의 diceNumber을 가져와서 diceNumber라는 변수에 넣을 것이다.
            final Player player = playerList.get(playerIdx);
            final Dice dice = player.getDice();
            final int diceNumber = dice.getDiceNumber();

            // 만약 현재 플레이어의 diceNumber가 2로 나누었을 때 0이라면
            // 즉 diceNumber가 짝수라면 다른 플레이어의 값을 빼앗을 것인데,
            // ODD 플레이어의 값을 빼앗을 것이다.

            // 만약 현재 플레이어의 diceNumber가 2로 나누었을 때 0이 아니라면
            // 즉 diceNumber가 홀수라면 다른 플레이어의 값을 빼앗을 것인데,
            // EVEN 플레이어의 값을 빼앗을 것이다.

            if (diceNumber % DECISION_EVEN == EVEN) {
                attackEverySpecificIndexPlayer(playerList.size(), ODD, playerIdx);
            } else {
                attackEverySpecificIndexPlayer(playerList.size(), EVEN, playerIdx);
            }

            System.out.println("현재 인덱스: " + playerIdx);
            System.out.println(playerList);

            // 현재 플레이어의 값에 따라 다른 플레이어들의 값을 변경하면서
            // 죽은 플레이어가 있는지 확인 후 리스트에서 제거하겠다.
            removeDeadPlayer();
        }
    }

    // 나의 주사위 값에 따라 다른 플레이어들을 공격할 것이다. (점수를 뺏을 것이다)
    // 나의 주사위가 짝수이면 홀수 플레이어를 공격
    // 나의 주사위가 홀수이면 짝수 플레이어를 공격

    // 따라서 해당 메소드를 사용할 때 입력받는 값은
    // 플레이어의 수와 플레이어가 짝수인지 홀수인지 판단할 수 있는 type이 필요하다.

    // 기존 선생님 풀이에서 playerIdx를 추가하여
    // 나를 제외한 다른 플레이어들의 값을 변경하도록 변경해보았다.

    private void attackEverySpecificIndexPlayer(int playerCount, int type, int playerIdx) {
        final int JUMP_IDX = 2;

        // type이 ODD라면 i는 1부터 플레이어 수만큼 돌며
        // 플레이어 리스트에서 i값에 해당하는 인덱스의 플레이어를 가져와서
        // player 객체를 생성할 것이고
        // player 객체의 dice를 가져와서 dice 객체를 생성할 것이다.

        // 여기서 i 값은 1씩 증가하는게 아니라 JUMP_IDX만큼 증가한다.
        // 즉 i가 1부터 시작이라면 1, 3, 5, 7, 9
        // i가 0부터 시작이라면 0, 2, 4, 6, 8, 10
        for (int i = type; i < playerCount; i += JUMP_IDX) {
            final Player player = playerList.get(i);
            final Dice dice = player.getDice();

            // 그리고 그 dice의 값을 subtractDiceNumber할 것이다.
            // Dice 클래스에 있는 메소드 내용과 같이 diceNumber--할 것이다.
            // 즉 1을 뺄 것이다.

            // 다만 나(playerIdx)의 점수는 빼지 않을 것이다.
            if(player != playerList.get(playerIdx)){
                dice.subtractDiceNumber();
            }
        }
    }

    // 죽은 플레이어를 없애는 메소드
    private void removeDeadPlayer() {
        // 플레이어 수만큼 루프를 돌며
        // player dice 객체와 diceNumber 변수를 생성하여 값을 넣을 것이다.
        for (int j = 0; j < playerList.size(); j++) {
            final Player player = playerList.get(j);
            final Dice dice = player.getDice();
            final int diceNumber = dice.getDiceNumber();

            // 만약 diceNumber가 0보다 작거나 같다면
            // 플레이어 리스트에서 해당 인덱스의 플레이어를 제거한다.
            if (diceNumber <= 0) {
                playerList.remove(j);
            }
        }
    }

    // 각 플레이어의 점수로 순위를 매기는 메소드
    public void printRank() {
        // rank는 일단 1부터 시작
        // 이전 플레이어의 점수와 비교해야하기 때문에
        // backupScore라는 변수를 생성해서 0으로 초기화할 것이다.
        // 같은 점수가 있을 경우 순위를 증가시키지 않아야 하므로 sameScoreCount라는 변수도 생성해서 0으로 초기화할 것이다.
        // 점수가 같은지 확인해야 하므로 boolean 타입의 isSameScore라는 변수를 생성해서 false로 초기화할 것이다.
        int rank = 1;
        int backupScore = 0;
        int sameScoreCount = 0;
        Boolean isSameScore = false;

        // 플레이어 리스트를 가져와서 내림차순으로 정렬할 것이다.
        // 즉 값이 큰 것부터 순차적으로 정렬한다.
        Collections.sort(playerList, Collections.reverseOrder());

        // 플레이어 수만큼 루프를 돌며 순위를 출력할 것이다.
        for (int i = 0; i < playerList.size(); i++) {
            // 첫번째 플레이어를 비교할 때는 우선 SameScore가 없을 것이기 때문에
            // false로 시작한다.
            isSameScore = false;

            // 내림차순으로 정렬한 플레이어 리스트의 첫번째 플레이어를 가져와서
            // player 객체를 생성할 것이다.
            // currentScore은 첫번째 플레이어의 diceNumber가 된다.
            final Player player = playerList.get(i);
            final int currentScore = player.getDice().getDiceNumber();

            // 만약 backupScore와 currentScore와 같다면
            // sameScoreCount를 증가시킨 후 isSameScore를 ture로 바꾼다.
            // 만약 backupScore와 currentScore와 같지 않다면
            // sameScoreCount에 0을 대입한다.
            if (backupScore == currentScore) {
                sameScoreCount++;
                isSameScore = true;
            } else { sameScoreCount = 0; }

            // 순위는 isSameScore ? 로 나타내는데,
            // true라면 rank++ - sameScoreCount를 반환한다.
            // 즉 같은 점수가 있다면 순위를 하나 올리고 sameScoreCount를 빼서 반환할 것이다.

            // 1등 12점, 2등 12점, 3등 12점, 4등 10점인 경우
            // 1등 플레이어 차례에 backupScore와 비교했을 때 같지 않으므로 sameScoreCount에 0을 대입하고
            // isSameScore은 false로 rank 초기값을 순위로 출력하고 ++을 할 것이다.
            // 즉 1등은 rank가 1로 출력된다.

            // 2등 플레이어 차례에 backupScore와 비교했을 때 동일하므로 sameScoreCount를 ++할 것이고
            // isSameScore는 true로 변경할 것이다.
            // 따라서 순위는 isSameScore의 true값인 rank++ - sameScoreCount가 된다.
            // 즉 1등 플레이어를 돌면서 rank는 2가 되었고
            // 2에서 ++된 sameScoreCount(=1)을 뺀 1이 된다.
            // 해당 코드를 수행하며 rank는 다시 ++이 되어 3으로 반환된다.

            // 3등 플레이어 차례에 backupScore와 비교했을 때 동일하므로 sameScoreCount를 ++할 것이고
            // isSameScore는 true로 변경할 것이다.
            // 따라서 순위는 isSameScore의 true값인 rank++ - sameScoreCount이 된다.
            // 즉 2등 플레이어를 돌면서 rank는 3이 되었고
            // 3에서 ++된 sameScoreCount(=2)을 뺀 1이 된다.
            // 해당 코드를 수행하며 rank는 다시 ++이 되어 4로 반환된다.

            // 4등 플레이어 차례에 backupScore와 비교했을 때 다르므로 sameScoreCount에 0을 대입할 것이고
            // isSameScore는 false가 되었으므로
            // 순위는 isSameScore의 false값인 rank++이 된다.
            // 즉 3등 플레이어를 돌면서 rank는 4가 되었고
            // 4등 플레이어는 순위로 4를 출력하고 rank는 다시 ++이 되어 5로 반환된다.
            System.out.println(
                    "순위: " + ((isSameScore) ? (rank++ - sameScoreCount) : (rank++))+
                            ", 점수: " + currentScore +
                            ", 이름: " + player.getName());

            // backupScore에는 현재 플레이어의 주사위 값을 대입한다.
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
