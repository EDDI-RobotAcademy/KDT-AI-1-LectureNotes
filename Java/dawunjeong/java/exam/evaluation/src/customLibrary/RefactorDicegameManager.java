package customLibrary;

import java.util.ArrayList;
import java.util.List;

public class RefactorDicegameManager {
    final private int PLAYER_NUM = 10;
    final private List<RefactorPlayer> playerList = new ArrayList<>();

    public RefactorDicegameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new RefactorPlayer("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }

    private List<RefactorPlayer> findTargetPlayerIndex (int currentPlayerIndex) {
        List<RefactorPlayer> targetPlayerList = new ArrayList<>();

        // 나의 다이스가 짝수이면
        if((playerList.get(currentPlayerIndex).getDiceNumber() & 2) == 0){
            int targetNum = 0;
            if(currentPlayerIndex % 2 == 1){
                targetNum = 4;
            }
            if(currentPlayerIndex % 2 == 0){
                targetNum = 5;
            }
            for(int i = 0; i < targetNum; i++){

                // 홀수 인덱스의 플레이어를 가져와서 타겟 플레이어 리스트에 넣자
                if(i % 2 == 1){
                    targetPlayerList.add(playerList.get(i));
                }
            }
        }
        // 나의 다이스가 홀수이면
        if((playerList.get(currentPlayerIndex).getDiceNumber() & 2) == 1){
            int targetNum2 = 0;
            if(currentPlayerIndex % 2 == 0){
                targetNum2 = 4;
            }
            if(currentPlayerIndex % 2 == 1){
                targetNum2 = 5;
            }
            for(int i = 0; i < playerList.size(); i++){
                // 짝수 인덱스의 플레이어를 가져와서 타겟 플레이어 리스트에 넣자
                if(i % 2 == 0){
                    targetPlayerList.add(playerList.get(i));
                }
            }
        }
        return targetPlayerList;
    }

    public void playGame() {
        for (int currentPlayerIdx = 0; currentPlayerIdx < PLAYER_NUM; currentPlayerIdx++) {

            int currentPlayerSpecialDiceNumber = playerList.get(currentPlayerIdx).getDiceNumber();

            final RefactorDicegameScore currentPlayerScore =
                    playerList.get(currentPlayerIdx).getGameScore();

            applyAbilityOfSpecialDice(
                    currentPlayerIdx,
                    currentPlayerSpecialDiceNumber,
                    currentPlayerScore);
        }
    }

    private void applyAbilityOfSpecialDice(
            int currentPlayerIdx,
            int currentPlayerSpecialDiceNumber,
            RefactorDicegameScore currentPlayerScore
    ) {
        final int STEAL_EVEN = 0;
        final int STEAL_ODD = 1;

        final int STEAL_SCORE = 1;

        switch (currentPlayerSpecialDiceNumber % 2) {
            case STEAL_EVEN: // 짝수라면
                List<RefactorPlayer> targetPlayerList;
                for(int i = 0; i < 1; i++){
                    targetPlayerList = findTargetPlayerIndex(currentPlayerIdx); // 타겟 플레이어 리스트에서 첫번재 애를 가져올거
                    RefactorDicegameScore targetPlayerScore = targetPlayerList.get(i).getGameScore();
                    targetPlayerScore.takeScoreOddplayer(currentPlayerScore, STEAL_SCORE);
                }
                break;

            case STEAL_ODD: // 짝수라면
                List<RefactorPlayer> targetPlayerList2;
                for(int i = 0; i < 1; i++){
                    targetPlayerList2 = findTargetPlayerIndex(currentPlayerIdx); // 타겟 플레이어 리스트에서 첫번재 애를 가져올거
                    RefactorDicegameScore targetPlayerScore = targetPlayerList2.get(i).getGameScore();
                    targetPlayerScore.takeScoreEvenplayer(currentPlayerScore, STEAL_SCORE);
                }
                break;
        }
    }

    public void printResult() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerList.get(i));
        }
    }

}
