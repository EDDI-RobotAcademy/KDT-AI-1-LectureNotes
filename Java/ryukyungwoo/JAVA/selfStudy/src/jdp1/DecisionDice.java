package jdp1;

public class DecisionDice {
    Player player = new Player();
    final private int FIRST_DICE = 0;
    final private int THIRD_DICE = 2;
    public boolean DecisionFirstDice() {
        if (player.getDiceList().get(FIRST_DICE).getDiceNumber() % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public int DecisionThirdDice () {
        return player.getDiceList().get(THIRD_DICE).getDiceNumber();
    }

    public int CalculateScoreFromThirdDiceNumber () {
        PlayerList playerList = new PlayerList();
        DecisionPlayer decisionPlayer = new DecisionPlayer();
        if (DecisionThirdDice() == 1) {
            for (int i = 0; i < playerList.getPlayerList().size(); i++) {
                decisionPlayer.CurrentPlayer(i).
            }
        }
    }
}
