package jdp1;

public class DecisionPlayer {
    private Player decisionPlayerNumber;
    PlayerList playerList = new PlayerList();
    public void CurrentPlayer (int idx) {
        decisionPlayerNumber = playerList.getPlayerList().get(idx);
    }

    public Player TargetPlayer () {
        for (int i = 0; i < playerList.getPlayerList().size(); i++) {
            if (playerList.getPlayerList().get(i) == decisionPlayerNumber) {
                continue;
            } else {
                return playerList.getPlayerList().get(i);
            }
        }
    }

}
