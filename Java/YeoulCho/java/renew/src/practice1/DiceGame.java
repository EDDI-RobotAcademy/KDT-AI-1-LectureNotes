package practice1;

import java.util.ArrayList;
import java.util.List;

public class DiceGame {

    final private int playerNumber = 2;
    final private List<Player> playerList =new ArrayList<>();

    public DiceGame(){
        for ( int i =0; i<playerNumber;i++){
            playerList.add(new Player("플레이어" + i+1));
            System.out.println(playerList);
        }
    }

    public int findTargetPlayerIndex(int currentPlayerIndex){ //상대편찾기
        int targetPlayerIndex=0;
        if(currentPlayerIndex ==0){ //현재플레이어가 0이라면
            return targetPlayerIndex=1; //타겟플레이어인덱스는 1
        }
        return targetPlayerIndex; // 타겟플레이서 인덱스찾기는 타겟플레이어 인덱스를 반환
    }

    private int findSpecialDiceNumber(int playerindex){
        final int Array_Bias = 1;
        final int Special_Dice_Index = 3 - Array_Bias;

        Dice currentPlayerSpecialDice = //현재플레이어의스페셜다이스의 다이스
                playerList.get(playerindex).getSelectedGameDice(Special_Dice_Index);
        if (currentPlayerSpecialDice == null){
            return 0;
        }

        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber();
        return currentPlayerSpecialDiceNumber;
    }



}
