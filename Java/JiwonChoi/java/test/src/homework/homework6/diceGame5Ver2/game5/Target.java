package homework.homework6.diceGame5Ver2.game5;

import utility.random.CustomRandom;

public class Target {
    Player myPlayer;
    Player targetPlayer;

    public Target() {
    }
    //나
    //나를 제외한 플레이어레이
    //에서 랜덤 선택?


    public void setTargetPlayer(Player targetPlayer) {
        this.targetPlayer = targetPlayer;
    }

    public Player getTargetPlayer() {
        return targetPlayer;
    }

    static Player findTargetPlayer (Player me) {
        boolean a = true;
        Target target = new Target();
        target.setTargetPlayer(new Player(targetPlayer));
        new Player targetPlayer = target.getTargetPlayer();

        while (a) {
            int randoNumber = CustomRandom.generateNumber(Game.playerList.size(), 1);
            target.setTargetPlayer(Game.getPlayerList().get(randoNumber));

            if (targetPlayer.getPlayerName() != me.getPlayerName()) {
                me.getTarget().setTargetPlayer(targetPlayer);
                a = false;
            }
        }
        return targetPlayer;//me.getTarget().getTargetPlayer();
    }

}
