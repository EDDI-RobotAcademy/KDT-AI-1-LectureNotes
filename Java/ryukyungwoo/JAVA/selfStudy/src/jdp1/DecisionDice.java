package jdp1;

class DecisionPlayer {
    PlayerList playerList = new PlayerList();
    public Player CurrentPlayer (int idx) {
        return playerList.getPlayerList().get(idx);
    }
}


public class DecisionDice {
    public DecisionDice(){

    }
    DecisionPlayer decisionPlayer = new DecisionPlayer();

    final private int THIRD_DICE = 2;
    final private int DICE_DECISION_NUM_ONE = 1;
    final private int DICE_DECISION_NUM_THREE = 3;
    final private int DICE_DECISION_NUM_FOUR = 4;
    private int currentPlayerScore;
    private int targetPlayerScore;
    private int decisionThirdDiceNumber;



    public int DecisionThirdDice () {
        for (int j = 0; j < decisionPlayer.playerList.getPlayerList().size(); j++) {
            decisionThirdDiceNumber = decisionPlayer.CurrentPlayer(j).getDiceList().get(THIRD_DICE).getDiceNumber();
        } return decisionThirdDiceNumber;
    }

    public void CalculateScoreFromThirdDiceNumber () {
        if (DecisionThirdDice() == DICE_DECISION_NUM_ONE) {
            for (int i = 0; i < decisionPlayer.playerList.getPlayerList().size(); i++) {
                currentPlayerScore = decisionPlayer.CurrentPlayer(i).getScore() + 3;
                for(int j =0; j< decisionPlayer.playerList.getPlayerList().size(); j++){
                    if(i == j){
                        continue;
                    } else {
                        targetPlayerScore = decisionPlayer.CurrentPlayer(j).getScore() - 3;
                    }
                }
            }
        }
        if (DecisionThirdDice() == DICE_DECISION_NUM_THREE) {
            for (int i = 0; i < decisionPlayer.playerList.getPlayerList().size(); i++) {
                currentPlayerScore = decisionPlayer.CurrentPlayer(i).getScore() + 2;
            }
        }
        if (DecisionThirdDice() == DICE_DECISION_NUM_FOUR) {
            for (int i = 0; i < decisionPlayer.playerList.getPlayerList().size(); i++) {
                currentPlayerScore = decisionPlayer.CurrentPlayer(i).getScore() - 777;
            }
        }
    }
}


