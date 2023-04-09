package homework.third;

import java.util.ArrayList;
import java.util.List;

// 친구 <- 추후 다수의 Player로 확장 가능성이 존재
// 주사위
// 점수
// 게임
class ThirdDiceGame {
    final private int PLAYER_NUM = 2;
    final private Player[] playerArray = new Player[PLAYER_NUM];
    List<Player> playerList=new ArrayList<>(PLAYER_NUM);

    public ThirdDiceGame() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerArray[i] = new Player("플레이어" + (i + 1));
            System.out.println(playerArray[i]);
        }
    }
    public void ThirdDiceGameList() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.set(i, new Player("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }
    private int findTargetPlayerIndex(int currentPlayerIndex){
        int targetPlayerIndex=0;
        if (currentPlayerIndex==0){
        targetPlayerIndex=1;
    }
    return targetPlayerIndex;
    }
    private int findSpecialDiceNumber (int playerIndex){
        final int ARRAY_BIAS=1;
        final int SPECIAL_DICE_INDEX=3-ARRAY_BIAS;

        GameDice currentPlayerSpecialDice= playerArray[playerIndex].getSeletedGameDices(SPECIAL_DICE_INDEX);

        if (currentPlayerSpecialDice==null){return 0;}
        int currentPlayerSpecialDiceNumber= currentPlayerSpecialDice.getDiceNumber();
        return currentPlayerSpecialDiceNumber;
}



    public void playGame() {

        final int STEAL=1;
        final int BUFF=3;
        final int DEATH=4;
        final int STEAL_SCORE=3;
        final int BUFF_SCORE=2;
        final int DEATH_SCORE=-1;





        for (int i=0; i<PLAYER_NUM;i++){

            int currentPlayerSpecialDiceNumber= findSpecialDiceNumber(i);
            if (currentPlayerSpecialDiceNumber==0){continue;}


            //타겟을 어떻게 찾을 것이가?
            int targetPlayerIndex= findTargetPlayerIndex(i);

            GameScore targetPlayerScore= playerArray[targetPlayerIndex].getGameScore();
            GameScore currentPlayerScore=playerArray[i].getGameScore();


            switch (currentPlayerSpecialDiceNumber){
                case STEAL:
                    targetPlayerScore.takeScore(currentPlayerScore,STEAL_SCORE);
                    break;

                case BUFF:
                    currentPlayerScore.addScore(BUFF_SCORE);
                    break;

                case DEATH:
                    currentPlayerScore.loseAll(DEATH_SCORE);
                    break;
        }

    }
}
    public void printResult(){
    for (int i=0;i<PLAYER_NUM;i++){
        System.out.println(playerArray[i]);
    }
    }
    public void checkWin(){
        GameScore firstPlayerScore=playerArray[0].getGameScore();
        GameScore secondPlayerScore=playerArray[1].getGameScore();

        if (firstPlayerScore.getTotalScore()>secondPlayerScore.getTotalScore()){
            System.out.println("승자는 "+playerArray[0].getName());
        }
        else {
            System.out.println("승자는 "+playerArray[1].getName());
        }
    }

}

public class TripleDiceTest {
    public static void main(String[] args) {
        ThirdDiceGame game = new ThirdDiceGame();
        System.out.println("점수 판정 이후");
        game.playGame();
        game.printResult();
        game.checkWin();
    }
}